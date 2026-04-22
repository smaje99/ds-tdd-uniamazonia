package co.edu.udla.ed.impl.scratch.search;

import co.edu.udla.ed.api.DisjointSet;

/**
 * Connectivity query for disjoint-set structures.
 *
 * @param <T> element type
 */
public class ConnectivitySearch<T> {

  /**
   * Delegates a connectivity query to the disjoint-set structure.
   *
   * @param set disjoint-set structure
   * @param first first value
   * @param second second value
   * @return {@code true} when both values share a representative
   */
  public boolean connected(DisjointSet<T> set, T first, T second) {
    return set.connected(first, second);
  }

}
