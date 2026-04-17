package co.edu.udla.ed.impl.collections;

import java.util.LinkedHashMap;
import java.util.Map;

import co.edu.udla.ed.api.HashTable;

/**
 * Hash-table adapter backed directly by {@link LinkedHashMap}.
 *
 * <p>
 * This wrapper is useful when students need to compare the project API with a
 * production-ready hash-based map. The use of {@link LinkedHashMap} preserves
 * deterministic iteration order internally, although the project hash-table API
 * does not currently expose iteration.
 * </p>
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class CollectionsHashTable<K, V> implements HashTable<K, V> {

  private final Map<K, V> data = new LinkedHashMap<>();

  /**
   * {@inheritDoc}
   *
   * @implNote Average-case time complexity is {@code O(1)}.
   */
  @Override
  public V put(K key, V value) {
    return data.put(key, value);
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Average-case time complexity is {@code O(1)}.
   */
  @Override
  public V get(K key) {
    return data.get(key);
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Average-case time complexity is {@code O(1)}.
   */
  @Override
  public V remove(K key) {
    return data.remove(key);
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Average-case time complexity is {@code O(1)}.
   */
  @Override
  public boolean containsKey(K key) {
    return data.containsKey(key);
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public int size() {
    return data.size();
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(n)} because all stored associations
   *           are discarded.
   */
  @Override
  public void clear() {
    data.clear();
  }

}
