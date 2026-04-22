package co.edu.udla.ed.impl.scratch.sorting;

import java.util.Comparator;

import co.edu.udla.ed.api.MutableIndexedSequence;

/**
 * Shared helpers for in-place sorting implementations.
 */
final class SortingSupport {

  private SortingSupport() {
  }

  static <T> Comparator<? super T> comparatorOrNatural(Comparator<? super T> comparator) {
    if (comparator != null) {
      return comparator;
    }
    return (left, right) -> {
      if (!(left instanceof Comparable<?> comparable)) {
        throw new IllegalArgumentException("Elements must implement Comparable when no comparator is provided.");
      }
      @SuppressWarnings("unchecked")
      Comparable<Object> natural = (Comparable<Object>) comparable;
      return natural.compareTo(right);
    };
  }

  static <T> void swap(MutableIndexedSequence<T> sequence, int left, int right) {
    T temporary = sequence.get(left);
    sequence.set(left, sequence.get(right));
    sequence.set(right, temporary);
  }

}
