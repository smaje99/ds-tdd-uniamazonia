package co.edu.udla.ed.impl.scratch.sorting;

import java.util.Comparator;

import co.edu.udla.ed.api.MutableIndexedSequence;
import co.edu.udla.ed.api.SortingAlgorithm;

public class MergeSort<T> implements SortingAlgorithm<T> {

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
