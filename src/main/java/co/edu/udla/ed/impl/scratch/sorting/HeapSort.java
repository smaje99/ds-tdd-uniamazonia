package co.edu.udla.ed.impl.scratch.sorting;

import java.util.Comparator;

import co.edu.udla.ed.api.MutableIndexedSequence;
import co.edu.udla.ed.api.SortingAlgorithm;

public class HeapSort<T> implements SortingAlgorithm<T> {

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
