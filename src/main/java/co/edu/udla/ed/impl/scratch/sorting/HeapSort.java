package co.edu.udla.ed.impl.scratch.sorting;

import java.util.Comparator;

import co.edu.udla.ed.api.MutableIndexedSequence;
import co.edu.udla.ed.api.SortingAlgorithm;

/**
 * In-place comparison-based heap sort over an indexed sequence.
 *
 * <p>
 * The algorithm first rearranges the sequence into a max-heap using the same
 * backing sequence, then repeatedly moves the current maximum to the end and
 * restores the heap property in the remaining prefix. It uses heap logic local
 * to the algorithm rather than the repository priority-queue abstraction.
 * </p>
 *
 * <p>
 * Time complexity is {@code O(n log n)} and extra space is {@code O(1)}. Heap
 * sort is not stable because heap swaps may reorder equal elements. When no
 * comparator is provided, elements must implement {@link Comparable}.
 * </p>
 *
 * @param <T> element type
 */
public class HeapSort<T> implements SortingAlgorithm<T> {

  /** {@inheritDoc} */
  @Override
  public void sort(MutableIndexedSequence<T> sequence, Comparator<? super T> comparator) {
    Comparator<? super T> actual = SortingSupport.comparatorOrNatural(comparator);
    int size = sequence.size();
    for (int index = size / 2 - 1; index >= 0; index--) {
      siftDown(sequence, actual, size, index);
    }
    for (int end = size - 1; end > 0; end--) {
      SortingSupport.swap(sequence, 0, end);
      siftDown(sequence, actual, end, 0);
    }
  }

  private void siftDown(MutableIndexedSequence<T> sequence, Comparator<? super T> comparator, int heapSize,
      int rootIndex) {
    int current = rootIndex;
    while (true) {
      int left = current * 2 + 1;
      int right = left + 1;
      int largest = current;

      if (left < heapSize && comparator.compare(sequence.get(left), sequence.get(largest)) > 0) {
        largest = left;
      }
      if (right < heapSize && comparator.compare(sequence.get(right), sequence.get(largest)) > 0) {
        largest = right;
      }
      if (largest == current) {
        return;
      }
      SortingSupport.swap(sequence, current, largest);
      current = largest;
    }
  }

}
