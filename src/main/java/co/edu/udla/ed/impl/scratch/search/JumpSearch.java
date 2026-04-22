package co.edu.udla.ed.impl.scratch.search;

import java.util.Comparator;

import co.edu.udla.ed.api.IndexedSequence;
import co.edu.udla.ed.api.LinearSearchResult;

/**
 * Jump search for sorted indexed sequences.
 *
 * @param <T> element type
 */
public class JumpSearch<T> {

  /**
   * Searches a naturally ordered sequence with jump search.
   *
   * @param sequence sorted indexed sequence
   * @param target value to locate
   * @return the matching index and value, or {@code notFound()}
   * @implNote Time complexity is {@code O(sqrt(n))}.
   */
  public LinearSearchResult<T> search(IndexedSequence<T> sequence, T target) {
    return search(sequence, target, null);
  }

  /**
   * Searches a comparator-ordered sequence with jump search.
   *
   * @param sequence sorted indexed sequence
   * @param target value to locate
   * @param comparator ordering used by the sequence, or {@code null} for
   *        natural ordering
   * @return the matching index and value, or {@code notFound()}
   * @implNote Time complexity is {@code O(sqrt(n))}.
   */
  public LinearSearchResult<T> search(IndexedSequence<T> sequence, T target, Comparator<? super T> comparator) {
    Comparator<? super T> actual = SearchSupport.comparatorOrNatural(comparator);
    int size = sequence.size();
    if (size == 0) {
      return LinearSearchResult.notFound();
    }

    int step = Math.max(1, (int) Math.sqrt(size));
    int previous = 0;
    int current = step;
    while (previous < size && actual.compare(sequence.get(Math.min(current, size) - 1), target) < 0) {
      previous = current;
      current += step;
      if (previous >= size) {
        return LinearSearchResult.notFound();
      }
    }

    for (int index = previous; index < Math.min(current, size); index++) {
      T value = sequence.get(index);
      int comparison = actual.compare(value, target);
      if (comparison == 0) {
        return LinearSearchResult.found(index, value);
      }
      if (comparison > 0) {
        break;
      }
    }
    return LinearSearchResult.notFound();
  }

}
