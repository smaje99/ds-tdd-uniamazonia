package co.edu.udla.ed.api;

/**
 * Defines the contract for a key-value hash table.
 *
 * <p>This abstraction stores values by key and offers average-case constant-time
 * insertion, lookup, and removal when the hash function distributes keys well.
 * The API is intentionally small so students can focus on hashing, collision
 * handling, and resizing policies.</p>
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public interface HashTable<K, V> {

  /**
   * Associates {@code value} with {@code key}.
   *
   * @param key the key to insert or update
   * @param value the value associated with the key
   * @return the previous value for {@code key}, or {@code null} if the key was
   *         not present
   */
  V put(K key, V value);

  /**
   * Returns the value currently associated with {@code key}.
   *
   * @param key the key to search for
   * @return the associated value, or {@code null} if the key is not present
   */
  V get(K key);

  /**
   * Removes the mapping associated with {@code key}.
   *
   * @param key the key to remove
   * @return the removed value, or {@code null} if the key was not present
   */
  V remove(K key);

  /**
   * Checks whether the table contains {@code key}.
   *
   * @param key the key to search for
   * @return {@code true} if the key exists; {@code false} otherwise
   */
  boolean containsKey(K key);

  /**
   * Returns the number of key-value mappings currently stored in the table.
   *
   * @return the number of entries
   */
  int size();

  /**
   * Checks whether the table contains no entries.
   *
   * @return {@code true} if the table is empty; {@code false} otherwise
   */
  default boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Removes all entries from the table.
   */
  void clear();

}
