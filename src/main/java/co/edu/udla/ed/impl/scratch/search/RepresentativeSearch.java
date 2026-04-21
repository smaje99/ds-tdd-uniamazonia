package co.edu.udla.ed.impl.scratch.search;

import co.edu.udla.ed.api.DisjointSet;
import co.edu.udla.ed.api.DisjointSetSearchResult;

/**
 * Representative lookup for disjoint-set structures.
 *
 * @param <T> element type
 */
public class RepresentativeSearch<T> {

  public DisjointSetSearchResult<T> search(DisjointSet<T> set, T value) {
    try {
      return new DisjointSetSearchResult<>(true, value, set.find(value));
    } catch (IllegalArgumentException exception) {
      return new DisjointSetSearchResult<>(false, value, null);
    }
  }

}
