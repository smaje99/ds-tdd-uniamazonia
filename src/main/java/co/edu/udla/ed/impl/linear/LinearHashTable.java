package co.edu.udla.ed.impl.linear;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import co.edu.udla.ed.api.HashTable;

/**
 * Hash-table API implementation backed by a linear list of entries.
 *
 * <p>
 * This class deliberately sacrifices hashing performance so students can
 * compare a hash-table interface against a simple sequential search strategy.
 * Every key-based operation scans the stored entries from left to right.
 * </p>
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class LinearHashTable<K, V> implements HashTable<K, V> {

  /**
   * Stored key-value pair for the linear table.
   */
  private static final class Entry<K, V> {
    private final K key;
    private V value;

    private Entry(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  private final List<Entry<K, V>> entries = new ArrayList<>();

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(n)} because the method must search
   *           for an existing key before deciding whether to update or append.
   */
  @Override
  public V put(K key, V value) {
    for (Entry<K, V> entry : entries) {
      if (Objects.equals(entry.key, key)) {
        V previous = entry.value;
        entry.value = value;
        return previous;
      }
    }
    entries.add(new Entry<>(key, value));
    return null;
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public V get(K key) {
    for (Entry<K, V> entry : entries) {
      if (Objects.equals(entry.key, key)) {
        return entry.value;
      }
    }
    return null;
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public V remove(K key) {
    for (int i = 0; i < entries.size(); i++) {
      Entry<K, V> entry = entries.get(i);
      if (Objects.equals(entry.key, key)) {
        entries.remove(i);
        return entry.value;
      }
    }
    return null;
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public boolean containsKey(K key) {
    for (Entry<K, V> entry : entries) {
      if (Objects.equals(entry.key, key)) {
        return true;
      }
    }
    return false;
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public int size() {
    return entries.size();
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public void clear() {
    entries.clear();
  }

}
