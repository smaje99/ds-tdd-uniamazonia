package co.edu.udla.ed.impl.scratch.sorting;

import java.util.Comparator;

import co.edu.udla.ed.api.MutableIndexedSequence;
import co.edu.udla.ed.api.SortingAlgorithm;

public class InsertionSort<T> implements SortingAlgorithm<T> {

  @Override
  public void sort(MutableIndexedSequence<T> sequence, Comparator<? super T> comparator) {
    Comparator<? super T> actual = SortingSupport.comparatorOrNatural(comparator);
    for (int index = 1; index < sequence.size(); index++) {
      T current = sequence.get(index);
      int position = index - 1;
      while (position >= 0 && actual.compare(sequence.get(position), current) > 0) {
        sequence.set(position + 1, sequence.get(position));
        position--;
      }
      sequence.set(position + 1, current);
    }
  }

}
