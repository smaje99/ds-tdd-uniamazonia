package co.edu.udla.ed.api;

import java.util.Comparator;

/**
 * Contract for sorting algorithms over mutable indexed sequences.
 *
 * @param <T> the element type
 */
public interface SortingAlgorithm<T> {

  /**
   * Sorts the supplied mutable indexed sequence in place.
   *
   * <p>Comparison-based algorithms use {@code comparator} when it is not
   * {@code null}; otherwise they require elements to implement
   * {@link Comparable}. Non-comparison algorithms may reject unsupported
   * comparators when their ordering is fixed by the algorithm.</p>
   *
   * @param sequence sequence to mutate into sorted order
   * @param comparator ordering strategy, or {@code null} for natural ordering
   */
  void sort(MutableIndexedSequence<T> sequence, Comparator<? super T> comparator);

  /**
   * Sorts the sequence in place using natural ordering.
   *
   * @param sequence sequence to mutate into sorted order
   */
  default void sort(MutableIndexedSequence<T> sequence) {
    sort(sequence, null);
  }

}
