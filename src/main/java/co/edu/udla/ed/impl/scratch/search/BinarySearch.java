package co.edu.udla.ed.impl.scratch.search;

import java.util.Comparator;

import co.edu.udla.ed.api.IndexedSequence;
import co.edu.udla.ed.api.LinearSearchResult;

/**
 * Binary search for sorted indexed sequences.
 *
 * @param <T> element type
 */
public class BinarySearch<T> {

  public LinearSearchResult<T> search(IndexedSequence<T> sequence, T target) {
    return search(sequence, target, null);
  }

  public LinearSearchResult<T> search(IndexedSequence<T> sequence, T target, Comparator<? super T> comparator) {
    Comparator<? super T> actual = SearchSupport.comparatorOrNatural(comparator);
    int left = 0;
    int right = sequence.size() - 1;
    while (left <= right) {
      int middle = left + (right - left) / 2;
      T value = sequence.get(middle);
      int comparison = actual.compare(value, target);
      if (comparison == 0) {
        return LinearSearchResult.found(middle, value);
      }
      if (comparison < 0) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }
    return LinearSearchResult.notFound();
  }

}
