package co.edu.udla.ed.api;

import java.util.Comparator;

/**
 * A doubly linked list interface that extends the SimpleList interface and
 * defines additional operations specific to a doubly linked list.
 *
 * @param <T> the type of elements in this list
 */
public interface DoublyList<T> extends List<T> {

  @Override
  DoublyList<T> sorted(SortingAlgorithm<T> algorithm);

  @Override
  DoublyList<T> sorted(SortingAlgorithm<T> algorithm, Comparator<? super T> comparator);
}
