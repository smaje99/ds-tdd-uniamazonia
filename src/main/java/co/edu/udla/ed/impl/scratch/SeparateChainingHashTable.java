package co.edu.udla.ed.impl.scratch;

import java.util.Objects;

import co.edu.udla.ed.api.HashTable;

/**
 * Hash-table implementation that resolves collisions with separate chaining.
 *
 * <p>
 * Each bucket of the backing array stores the head of a singly linked chain of
 * entries. Keys that hash to the same bucket index are linked together in that
 * chain. This design keeps the basic table structure simple for students: the
 * array locates a bucket, and the linked list inside that bucket resolves
 * collisions.
 * </p>
 *
 * <p>
 * The table grows automatically when the configured load-factor threshold is
 * exceeded. During resizing, all entries are rehashed into a larger bucket
 * array so average lookup and update costs stay close to constant time.
 * </p>
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class SeparateChainingHashTable<K, V> implements HashTable<K, V> {

  private static final int DEFAULT_CAPACITY = 16;
  private static final double DEFAULT_LOAD_FACTOR = 0.75;

  /**
   * Entry node stored inside a collision chain.
   *
   * <p>
   * Each node stores one key-value pair plus a reference to the next entry in
   * the same bucket.
   * </p>
   */
  private static final class Entry<K, V> {
    private final K key;
    private V value;
    private Entry<K, V> next;

    private Entry(K key, V value, Entry<K, V> next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  private Entry<K, V>[] buckets;
  private final double loadFactor;
  private int threshold;
  private int size;

  /**
   * Creates a table with the default capacity and default load factor.
   *
   * @implNote Construction is {@code O(1)} because it allocates the initial
   *           bucket array and stores configuration values.
   */
  public SeparateChainingHashTable() {
    this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
  }

  /**
   * Creates a table with a custom initial capacity and the default load factor.
   *
   * @param initialCapacity the number of buckets in the initial table
   *
   * @implNote Construction is {@code O(1)}.
   */
  public SeparateChainingHashTable(int initialCapacity) {
    this(initialCapacity, DEFAULT_LOAD_FACTOR);
  }

  /**
   * Creates a table with custom capacity and load-factor settings.
   *
   * @param initialCapacity the number of buckets in the initial table
   * @param loadFactor the resize threshold expressed as a ratio of
   *        {@code size / bucketCount}
   * @throws IllegalArgumentException if {@code initialCapacity <= 0}
   * @throws IllegalArgumentException if {@code loadFactor <= 0} or is not a
   *         valid numeric value
   *
   * @implNote Construction is {@code O(1)}.
   */
  @SuppressWarnings("unchecked")
  public SeparateChainingHashTable(int initialCapacity, double loadFactor) {
    if (initialCapacity <= 0) {
      throw new IllegalArgumentException("Initial capacity must be greater than zero.");
    }
    if (loadFactor <= 0.0 || Double.isNaN(loadFactor)) {
      throw new IllegalArgumentException("Load factor must be a positive number.");
    }

    this.buckets = new Entry[initialCapacity];
    this.loadFactor = loadFactor;
    this.threshold = Math.max(1, (int) (initialCapacity * loadFactor));
    this.size = 0;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * If the key is already present, this method replaces its associated value
   * and returns the previous one. Otherwise, it inserts a new entry at the
   * front of the appropriate collision chain.
   * </p>
   *
   * <p>
   * Null keys are supported because bucket selection uses
   * {@link Objects#hashCode(Object)}, which safely maps {@code null} to
   * {@code 0}.
   * </p>
   *
   * @implNote Average-case time complexity is {@code O(1)}. In the worst case,
   *           if many keys collide into one bucket, it becomes {@code O(n)}.
   *           A resize step costs {@code O(n)}, but it happens only
   *           occasionally.
   */
  @Override
  public V put(K key, V value) {
    ensureCapacity(size + 1);

    int index = bucketIndex(key, buckets.length);
    Entry<K, V> current = buckets[index];
    while (current != null) {
      if (Objects.equals(current.key, key)) {
        V previous = current.value;
        current.value = value;
        return previous;
      }
      current = current.next;
    }

    buckets[index] = new Entry<>(key, value, buckets[index]);
    size++;
    return null;
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Average-case time complexity is {@code O(1)}. Worst-case time is
   *           {@code O(n)} when collision chains become long.
   */
  @Override
  public V get(K key) {
    Entry<K, V> current = buckets[bucketIndex(key, buckets.length)];
    while (current != null) {
      if (Objects.equals(current.key, key)) {
        return current.value;
      }
      current = current.next;
    }
    return null;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * When the key is found, the method unlinks the matching entry from its
   * bucket chain and returns the removed value. If the key is absent, the table
   * remains unchanged and the method returns {@code null}.
   * </p>
   *
   * @implNote Average-case time complexity is {@code O(1)}. Worst-case time is
   *           {@code O(n)}.
   */
  @Override
  public V remove(K key) {
    int index = bucketIndex(key, buckets.length);
    Entry<K, V> current = buckets[index];
    Entry<K, V> previous = null;

    while (current != null) {
      if (Objects.equals(current.key, key)) {
        if (previous == null) {
          buckets[index] = current.next;
        } else {
          previous.next = current.next;
        }
        size--;
        return current.value;
      }
      previous = current;
      current = current.next;
    }

    return null;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * This method handles the subtle case where a stored key is associated with a
   * {@code null} value. A plain {@code get(key) != null} check would incorrectly
   * report that such a key is absent, so the implementation performs an
   * additional explicit search when needed.
   * </p>
   *
   * @implNote Average-case time complexity is {@code O(1)}. Worst-case time is
   *           {@code O(n)}.
   */
  @Override
  public boolean containsKey(K key) {
    return get(key) != null || containsNullValueForKey(key);
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(1)} because the value is maintained
   *           incrementally.
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(m)}, where {@code m} is the number of
   *           buckets, because each bucket reference is reset explicitly.
   */
  @Override
  public void clear() {
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = null;
    }
    size = 0;
  }

  /**
   * Searches for a key that may be associated with a {@code null} value.
   *
   * @param key the key to search for
   * @return {@code true} if the key exists in the table, even if its stored
   *         value is {@code null}; {@code false} otherwise
   *
   * @implNote Average-case time complexity is {@code O(1)}. Worst-case time is
   *           {@code O(n)}.
   */
  private boolean containsNullValueForKey(K key) {
    Entry<K, V> current = buckets[bucketIndex(key, buckets.length)];
    while (current != null) {
      if (Objects.equals(current.key, key)) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  /**
   * Grows the table when inserting one more element would exceed the load
   * threshold.
   *
   * @param neededSize the logical size after the pending insertion
   *
   * @implNote The check itself is {@code O(1)}. When growth is required, the
   *           resize step is {@code O(n)} because every stored entry must be
   *           rehashed.
   */
  private void ensureCapacity(int neededSize) {
    if (neededSize <= threshold) {
      return;
    }
    resize(buckets.length * 2);
  }

  /**
   * Rehashes all existing entries into a larger bucket array.
   *
   * @param newCapacity the number of buckets in the new table
   *
   * @implNote Time complexity is {@code O(n + m)}, dominated by visiting each
   *           stored entry and redistributing it into the new array.
   */
  @SuppressWarnings("unchecked")
  private void resize(int newCapacity) {
    Entry<K, V>[] oldBuckets = buckets;
    buckets = new Entry[newCapacity];
    threshold = Math.max(1, (int) (newCapacity * loadFactor));

    for (Entry<K, V> bucket : oldBuckets) {
      Entry<K, V> current = bucket;
      while (current != null) {
        Entry<K, V> next = current.next;
        int newIndex = bucketIndex(current.key, newCapacity);
        current.next = buckets[newIndex];
        buckets[newIndex] = current;
        current = next;
      }
    }
  }

  /**
   * Computes the bucket index for a key under a specific table capacity.
   *
   * @param key the key whose bucket should be computed
   * @param capacity the number of buckets available in the target table
   * @return the normalized bucket index in the range {@code [0, capacity)}
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  private int bucketIndex(K key, int capacity) {
    return (Objects.hashCode(key) & 0x7fffffff) % capacity;
  }

}
