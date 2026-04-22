package co.edu.udla.ed.impl.scratch.sorting;

import java.util.Comparator;

import co.edu.udla.ed.api.MutableIndexedSequence;
import co.edu.udla.ed.api.SortingAlgorithm;

/**
 * In-place selection sort over a mutable indexed sequence.
 *
 * <p>
 * Each pass finds the smallest value in the unsorted suffix and swaps it into
 * the next position of the sorted prefix. The algorithm is simple and performs
 * a predictable number of comparisons, but it is not stable because swaps can
 * move equal values past each other.
 * </p>
 *
 * <p>
 * Time complexity is {@code O(n^2)} and extra space is {@code O(1)}. When no
 * comparator is provided, elements must implement {@link Comparable}.
 * </p>
 *
 * @param <T> element type
 */
public class SelectionSort<T> implements SortingAlgorithm<T> {

  /** {@inheritDoc} */
  @Override
  public void sort(MutableIndexedSequence<T> sequence, Comparator<? super T> comparator) {
    Comparator<? super T> actual = SortingSupport.comparatorOrNatural(comparator);
    for (int start = 0; start < sequence.size() - 1; start++) {
      int smallest = start;
      for (int index = start + 1; index < sequence.size(); index++) {
        if (actual.compare(sequence.get(index), sequence.get(smallest)) < 0) {
          smallest = index;
        }
      }
      if (smallest != start) {
        SortingSupport.swap(sequence, start, smallest);
      }
    }
  }

}
