package co.edu.udla.ed.impl.scratch.sorting;

import java.util.Comparator;

import co.edu.udla.ed.api.MutableIndexedSequence;
import co.edu.udla.ed.api.SortingAlgorithm;

/**
 * Stable merge sort over a mutable indexed sequence.
 *
 * <p>
 * The algorithm recursively divides the sequence into halves, sorts each half,
 * and merges the ordered halves into an auxiliary buffer. It preserves the
 * relative order of equal elements by taking from the left half first when
 * values compare as equal.
 * </p>
 *
 * <p>
 * Time complexity is {@code O(n log n)} and extra space is {@code O(n)}. When
 * no comparator is provided, elements must implement {@link Comparable}.
 * </p>
 *
 * @param <T> element type
 */
public class MergeSort<T> implements SortingAlgorithm<T> {

  /** {@inheritDoc} */
  @Override
  public void sort(MutableIndexedSequence<T> sequence, Comparator<? super T> comparator) {
    if (sequence.size() < 2) {
      return;
    }
    Comparator<? super T> actual = SortingSupport.comparatorOrNatural(comparator);
    Object[] buffer = new Object[sequence.size()];
    sort(sequence, actual, buffer, 0, sequence.size() - 1);
  }

  private void sort(MutableIndexedSequence<T> sequence, Comparator<? super T> comparator, Object[] buffer, int left,
      int right) {
    if (left >= right) {
      return;
    }
    int middle = left + (right - left) / 2;
    sort(sequence, comparator, buffer, left, middle);
    sort(sequence, comparator, buffer, middle + 1, right);
    merge(sequence, comparator, buffer, left, middle, right);
  }

  private void merge(MutableIndexedSequence<T> sequence, Comparator<? super T> comparator, Object[] buffer, int left,
      int middle, int right) {
    int i = left;
    int j = middle + 1;
    int k = left;

    while (i <= middle && j <= right) {
      if (comparator.compare(sequence.get(i), sequence.get(j)) <= 0) {
        buffer[k++] = sequence.get(i++);
      } else {
        buffer[k++] = sequence.get(j++);
      }
    }
    while (i <= middle) {
      buffer[k++] = sequence.get(i++);
    }
    while (j <= right) {
      buffer[k++] = sequence.get(j++);
    }
    for (int index = left; index <= right; index++) {
      @SuppressWarnings("unchecked")
      T value = (T) buffer[index];
      sequence.set(index, value);
    }
  }

}
