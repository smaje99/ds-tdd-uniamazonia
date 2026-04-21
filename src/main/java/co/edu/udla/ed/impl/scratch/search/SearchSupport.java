package co.edu.udla.ed.impl.scratch.search;

import java.util.Comparator;

final class SearchSupport {

  private SearchSupport() {
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

}
