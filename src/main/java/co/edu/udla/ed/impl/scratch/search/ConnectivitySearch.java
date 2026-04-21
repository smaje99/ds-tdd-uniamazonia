package co.edu.udla.ed.impl.scratch.search;

import co.edu.udla.ed.api.DisjointSet;

/**
 * Connectivity query for disjoint-set structures.
 *
 * @param <T> element type
 */
public class ConnectivitySearch<T> {

  public boolean connected(DisjointSet<T> set, T first, T second) {
    return set.connected(first, second);
  }

}
