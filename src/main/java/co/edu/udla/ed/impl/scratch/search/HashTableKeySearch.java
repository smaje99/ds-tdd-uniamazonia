package co.edu.udla.ed.impl.scratch.search;

import co.edu.udla.ed.api.HashTable;
import co.edu.udla.ed.api.KeyValueSearchResult;

/**
 * Key lookup algorithm for hash-table abstractions.
 *
 * @param <K> key type
 * @param <V> value type
 */
public class HashTableKeySearch<K, V> {

  /**
   * Looks up a key and packages the result for exercise code.
   *
   * @param table hash table to inspect
   * @param key key to locate
   * @return found flag, searched key, and stored value when present
   * @implNote Average time complexity is {@code O(1)} for well-distributed
   *           hash tables.
   */
  public KeyValueSearchResult<K, V> search(HashTable<K, V> table, K key) {
    boolean found = table.containsKey(key);
    return new KeyValueSearchResult<>(found, key, found ? table.get(key) : null);
  }

}
