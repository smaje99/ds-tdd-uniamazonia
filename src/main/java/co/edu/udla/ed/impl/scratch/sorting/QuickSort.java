package co.edu.udla.ed.impl.scratch.sorting;

import java.util.Comparator;

import co.edu.udla.ed.api.MutableIndexedSequence;
import co.edu.udla.ed.api.SortingAlgorithm;

/**
 * In-place quicksort over a mutable indexed sequence.
 *
 * <p>
 * This implementation uses the last element of each partition as a deterministic
 * pivot. Values less than or equal to the pivot are moved to the left side and
 * values greater than the pivot remain on the right side before the partitions
 * are sorted recursively.
 * </p>
 *
 * <p>
 * Average time complexity is {@code O(n log n)}, worst-case time complexity is
 * {@code O(n^2)}, and recursion uses {@code O(log n)} stack space on balanced
 * partitions. Quicksort is not stable. When no comparator is provided, elements
 * must implement {@link Comparable}.
 * </p>
 *
 * @param <T> element type
 */
public class QuickSort<T> implements SortingAlgorithm<T> {

  /** {@inheritDoc} */
  @Override
  public void sort(MutableIndexedSequence<T> sequence, Comparator<? super T> comparator) {
    Comparator<? super T> actual = SortingSupport.comparatorOrNatural(comparator);
    quickSort(sequence, actual, 0, sequence.size() - 1);
  }

  private void quickSort(MutableIndexedSequence<T> sequence, Comparator<? super T> comparator, int left, int right) {
    if (left >= right) {
      return;
    }
    int pivotIndex = partition(sequence, comparator, left, right);
    quickSort(sequence, comparator, left, pivotIndex - 1);
    quickSort(sequence, comparator, pivotIndex + 1, right);
  }

  private int partition(MutableIndexedSequence<T> sequence, Comparator<? super T> comparator, int left, int right) {
    T pivot = sequence.get(right);
    int smallerBoundary = left;
    for (int index = left; index < right; index++) {
      if (comparator.compare(sequence.get(index), pivot) <= 0) {
        SortingSupport.swap(sequence, smallerBoundary, index);
        smallerBoundary++;
      }
    }
    SortingSupport.swap(sequence, smallerBoundary, right);
    return smallerBoundary;
  }

}
