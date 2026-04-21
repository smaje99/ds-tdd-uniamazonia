package co.edu.udla.ed.impl.scratch.sorting;

import java.util.Comparator;

import co.edu.udla.ed.api.MutableIndexedSequence;
import co.edu.udla.ed.api.SortingAlgorithm;

public class BubbleSort<T> implements SortingAlgorithm<T> {

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
