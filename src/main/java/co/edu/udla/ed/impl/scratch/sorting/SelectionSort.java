package co.edu.udla.ed.impl.scratch.sorting;

import java.util.Comparator;

import co.edu.udla.ed.api.MutableIndexedSequence;
import co.edu.udla.ed.api.SortingAlgorithm;

public class SelectionSort<T> implements SortingAlgorithm<T> {

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
