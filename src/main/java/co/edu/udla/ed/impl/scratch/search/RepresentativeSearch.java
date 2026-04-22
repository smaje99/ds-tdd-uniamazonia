package co.edu.udla.ed.impl.scratch.search;

import co.edu.udla.ed.api.DisjointSet;
import co.edu.udla.ed.api.DisjointSetSearchResult;

/**
 * Representative lookup for disjoint-set structures.
 *
 * @param <T> element type
 */
public class RepresentativeSearch<T> {

  /**
   * Finds the representative for a value without throwing when absent.
   *
   * @param set disjoint-set structure
   * @param value value to locate
   * @return a found result with the representative, or an absent result
   */
  public DisjointSetSearchResult<T> search(DisjointSet<T> set, T value) {
    try {
      return new DisjointSetSearchResult<>(true, value, set.find(value));
    } catch (IllegalArgumentException exception) {
      return new DisjointSetSearchResult<>(false, value, null);
    }
  }

}
