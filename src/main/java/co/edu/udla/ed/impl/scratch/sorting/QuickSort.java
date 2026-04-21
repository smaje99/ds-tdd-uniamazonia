package co.edu.udla.ed.impl.scratch.sorting;

import java.util.Comparator;

import co.edu.udla.ed.api.MutableIndexedSequence;
import co.edu.udla.ed.api.SortingAlgorithm;

public class QuickSort<T> implements SortingAlgorithm<T> {

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
