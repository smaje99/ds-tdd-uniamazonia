package co.edu.udla.ed.api;

/**
 * Result of a key-value lookup.
 *
 * @param found whether the key exists
 * @param key requested key
 * @param value associated value, or {@code null} when absent
 * @param <K> key type
 * @param <V> value type
 */
public record KeyValueSearchResult<K, V>(boolean found, K key, V value) {
}
