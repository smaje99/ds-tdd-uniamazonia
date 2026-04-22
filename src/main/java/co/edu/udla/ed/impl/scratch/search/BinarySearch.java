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

  /**
   * Searches a naturally ordered sequence.
   *
   * @param sequence sorted indexed sequence
   * @param target value to locate
   * @return the matching index and value, or {@code notFound()}
   * @implNote Time complexity is {@code O(log n)}.
   */
  public LinearSearchResult<T> search(IndexedSequence<T> sequence, T target) {
    return search(sequence, target, null);
  }

  /**
   * Searches a sequence sorted according to the provided comparator.
   *
   * @param sequence sorted indexed sequence
   * @param target value to locate
   * @param comparator ordering used by the sequence, or {@code null} for
   *        natural ordering
   * @return the matching index and value, or {@code notFound()}
   * @implNote Time complexity is {@code O(log n)}.
   */
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
