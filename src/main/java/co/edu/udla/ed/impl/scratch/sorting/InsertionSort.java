package co.edu.udla.ed.impl.scratch.sorting;

import java.util.Comparator;

import co.edu.udla.ed.api.MutableIndexedSequence;
import co.edu.udla.ed.api.SortingAlgorithm;

/**
 * Stable insertion sort over a mutable indexed sequence.
 *
 * <p>
 * The algorithm grows a sorted prefix one element at a time. Each new element
 * is shifted left until every value before it is less than or equal to it. This
 * makes insertion sort easy to reason about and efficient on nearly sorted
 * inputs.
 * </p>
 *
 * <p>
 * Worst-case time complexity is {@code O(n^2)} and extra space is {@code O(1)}.
 * When no comparator is provided, elements must implement {@link Comparable}.
 * </p>
 *
 * @param <T> element type
 */
public class InsertionSort<T> implements SortingAlgorithm<T> {

  /** {@inheritDoc} */
  @Override
  public void sort(MutableIndexedSequence<T> sequence, Comparator<? super T> comparator) {
    Comparator<? super T> actual = SortingSupport.comparatorOrNatural(comparator);
    for (int index = 1; index < sequence.size(); index++) {
      T current = sequence.get(index);
      int position = index - 1;
      while (position >= 0 && actual.compare(sequence.get(position), current) > 0) {
        sequence.set(position + 1, sequence.get(position));
        position--;
      }
      sequence.set(position + 1, current);
    }
  }

}
