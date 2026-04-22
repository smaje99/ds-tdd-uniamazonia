package co.edu.udla.ed.impl.scratch;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import co.edu.udla.ed.api.HashTable;

/**
 * Hash table that resolves collisions with linear probing and tombstones.
 *
 * <p>The table keeps two counts: {@code size} for live mappings and
 * {@code usedSlots} for live mappings plus deleted slots. Deleted slots are
 * reused by insertion but still affect probing, so the table grows before the
 * occupied-slot load becomes too high.</p>
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class OpenAddressingHashTable<K, V> implements HashTable<K, V> {

  private static final int DEFAULT_CAPACITY = 16;
  private static final double LOAD_FACTOR = 0.60;

  private static final class Entry<K, V> implements HashTable.Entry<K, V> {
    private final K key;
    private V value;
    private boolean deleted;

    private Entry(K key, V value) {
      this.key = key;
      this.value = value;
      this.deleted = false;
    }

    @Override
    public K key() {
      return key;
    }

    @Override
    public V value() {
      return value;
    }
  }

  private Entry<K, V>[] table;
  private int size;
  private int usedSlots;

  /**
   * Creates an empty table with default capacity.
   */
  public OpenAddressingHashTable() {
    this(DEFAULT_CAPACITY);
  }

  /**
   * Creates an empty table with the requested initial capacity.
   *
   * @param capacity backing array length
   * @throws IllegalArgumentException if {@code capacity <= 0}
   */
  @SuppressWarnings("unchecked")
  public OpenAddressingHashTable(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Capacity must be greater than zero.");
    }
    this.table = new Entry[capacity];
  }

  /**
   * Inserts or updates a mapping.
   *
   * @param key key to insert or update
   * @param value value to associate with {@code key}
   * @return the previous value for {@code key}, or {@code null} when inserting a
   *         new mapping
   * @implNote Average time complexity is {@code O(1)}; resizing takes
   *           {@code O(n)} but happens only when the load threshold is exceeded.
   */
  @Override
  public V put(K key, V value) {
    ensureCapacity();
    return putInternal(key, value, table);
  }

  /**
   * Looks up a value by key.
   *
   * @param key key to locate
   * @return the stored value, or {@code null} when absent
   * @implNote Average time complexity is {@code O(1)}.
   */
  @Override
  public V get(K key) {
    int slot = locateSlot(key);
    return slot >= 0 ? table[slot].value : null;
  }

  /**
   * Removes a mapping by marking its slot as a tombstone.
   *
   * @param key key to remove
   * @return the removed value, or {@code null} when absent
   * @implNote Average time complexity is {@code O(1)}.
   */
  @Override
  public V remove(K key) {
    int slot = locateSlot(key);
    if (slot < 0) {
      return null;
    }
    Entry<K, V> entry = table[slot];
    V previous = entry.value;
    entry.deleted = true;
    entry.value = null;
    size--;
    return previous;
  }

  /**
   * Checks whether a live mapping exists for a key.
   *
   * @param key key to locate
   * @return {@code true} when the key is present
   * @implNote Average time complexity is {@code O(1)}.
   */
  @Override
  public boolean containsKey(K key) {
    return locateSlot(key) >= 0;
  }

  /**
   * Returns the number of live mappings.
   *
   * @return logical table size, excluding tombstones
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Removes all mappings and tombstones while keeping the current capacity.
   *
   * @implNote Time complexity is {@code O(m)}, where {@code m} is the backing
   *           array length.
   */
  @Override
  public void clear() {
    for (int i = 0; i < table.length; i++) {
      table[i] = null;
    }
    size = 0;
    usedSlots = 0;
  }

  /**
   * Iterates over live entries in backing-array order.
   *
   * @return an iterator that skips empty slots and tombstones
   */
  @Override
  public Iterator<HashTable.Entry<K, V>> iterator() {
    return new Iterator<HashTable.Entry<K, V>>() {
      private int index = advance(0);

      @Override
      public boolean hasNext() {
        return index < table.length;
      }

      @Override
      public HashTable.Entry<K, V> next() {
        if (!hasNext()) {
          throw new NoSuchElementException("Hash table iterator exhausted.");
        }
        Entry<K, V> entry = table[index];
        index = advance(index + 1);
        return entry;
      }
    };
  }

  private void ensureCapacity() {
    if ((usedSlots + 1.0) / table.length <= LOAD_FACTOR) {
      return;
    }
    resize(table.length * 2);
  }

  private V putInternal(K key, V value, Entry<K, V>[] target) {
    int firstDeleted = -1;
    int capacity = target.length;
    int hash = bucketIndex(key, capacity);
    for (int step = 0; step < capacity; step++) {
      int index = (hash + step) % capacity;
      Entry<K, V> entry = target[index];
      if (entry == null) {
        int insertAt = firstDeleted >= 0 ? firstDeleted : index;
        target[insertAt] = new Entry<>(key, value);
        size++;
        if (firstDeleted < 0) {
          usedSlots++;
        }
        return null;
      }
      if (entry.deleted) {
        if (firstDeleted < 0) {
          firstDeleted = index;
        }
        continue;
      }
      if (Objects.equals(entry.key, key)) {
        V previous = entry.value;
        entry.value = value;
        return previous;
      }
    }
    throw new IllegalStateException("Hash table probing overflow.");
  }

  private int locateSlot(K key) {
    int hash = bucketIndex(key, table.length);
    for (int step = 0; step < table.length; step++) {
      int index = (hash + step) % table.length;
      Entry<K, V> entry = table[index];
      if (entry == null) {
        return -1;
      }
      if (!entry.deleted && Objects.equals(entry.key, key)) {
        return index;
      }
    }
    return -1;
  }

  @SuppressWarnings("unchecked")
  private void resize(int capacity) {
    Entry<K, V>[] old = table;
    table = new Entry[capacity];
    size = 0;
    usedSlots = 0;
    for (Entry<K, V> entry : old) {
      if (entry != null && !entry.deleted) {
        putInternal(entry.key, entry.value, table);
      }
    }
  }

  private int advance(int start) {
    int index = start;
    while (index < table.length) {
      Entry<K, V> entry = table[index];
      if (entry != null && !entry.deleted) {
        return index;
      }
      index++;
    }
    return table.length;
  }

  private int bucketIndex(K key, int capacity) {
    return (Objects.hashCode(key) & 0x7fffffff) % capacity;
  }
}
