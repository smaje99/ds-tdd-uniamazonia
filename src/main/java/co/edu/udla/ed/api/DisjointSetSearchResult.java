package co.edu.udla.ed.api;

/**
 * Result of searching an element in a disjoint-set structure.
 *
 * @param found whether the value exists in the partition
 * @param value requested value
 * @param representative set representative, or {@code null} when absent
 * @param <T> element type
 */
public record DisjointSetSearchResult<T>(boolean found, T value, T representative) {
}
