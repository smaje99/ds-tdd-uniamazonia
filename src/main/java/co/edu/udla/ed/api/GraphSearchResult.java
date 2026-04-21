package co.edu.udla.ed.api;

import java.util.List;

/**
 * Result of a graph search.
 *
 * @param found whether the target is reachable
 * @param visited vertices observed by the traversal
 * @param path path to the target when the algorithm computes one
 * @param <V> vertex type
 */
public record GraphSearchResult<V>(boolean found, List<V> visited, List<V> path) {
}
