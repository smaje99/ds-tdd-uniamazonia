package co.edu.udla.ed.impl.scratch.sorting;

import java.util.Comparator;

import co.edu.udla.ed.api.MutableIndexedSequence;
import co.edu.udla.ed.api.SortingAlgorithm;

/**
 * Stable comparison-based bubble sort over a mutable indexed sequence.
 *
 * <p>
 * The algorithm repeatedly compares adjacent values and swaps inverted pairs
 * until the largest remaining value has moved to the end of the unsorted
 * region. It is intentionally simple and useful for teaching local swaps, but
 * it performs quadratic work on typical inputs.
 * </p>
 *
 * <p>
 * Time complexity is {@code O(n^2)} and extra space is {@code O(1)}. When no
 * comparator is provided, elements must implement {@link Comparable}.
 * </p>
 *
 * @param <T> element type
 */
public class BubbleSort<T> implements SortingAlgorithm<T> {

  /** {@inheritDoc} */
  @Override
  public void sort(MutableIndexedSequence<T> sequence, Comparator<? super T> comparator) {
    Comparator<? super T> actual = SortingSupport.comparatorOrNatural(comparator);
    for (int end = sequence.size() - 1; end > 0; end--) {
      for (int index = 0; index < end; index++) {
        if (actual.compare(sequence.get(index), sequence.get(index + 1)) > 0) {
          SortingSupport.swap(sequence, index, index + 1);
        }
      }
    }
  }

}
