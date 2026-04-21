package co.edu.udla.ed.impl.scratch.sorting;

import java.util.Comparator;

import co.edu.udla.ed.api.MutableIndexedSequence;
import co.edu.udla.ed.api.SortingAlgorithm;

public class ShellSort<T> implements SortingAlgorithm<T> {

  @Override
  public void sort(MutableIndexedSequence<T> sequence, Comparator<? super T> comparator) {
    Comparator<? super T> actual = SortingSupport.comparatorOrNatural(comparator);
    for (int gap = sequence.size() / 2; gap > 0; gap /= 2) {
      for (int index = gap; index < sequence.size(); index++) {
        T current = sequence.get(index);
        int position = index;
        while (position >= gap && actual.compare(sequence.get(position - gap), current) > 0) {
          sequence.set(position, sequence.get(position - gap));
          position -= gap;
        }
        sequence.set(position, current);
      }
    }
  }

}
