package co.edu.udla.ed.api;

import java.util.Comparator;

/**
 * Contract for sorting algorithms over mutable indexed sequences.
 *
 * @param <T> the element type
 */
public interface SortingAlgorithm<T> {

  void sort(MutableIndexedSequence<T> sequence, Comparator<? super T> comparator);

  default void sort(MutableIndexedSequence<T> sequence) {
    sort(sequence, null);
  }

}
