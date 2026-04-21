package co.edu.udla.ed.api;

import java.util.Comparator;

/**
 * A circular linked list interface that extends the List interface and defines
 * additional operations specific to a circular linked list.
 *
 * @param <T> the type of elements in this list
 */
public interface CircularList<T> extends List<T> {

  @Override
  CircularList<T> sorted(SortingAlgorithm<T> algorithm);

  @Override
  CircularList<T> sorted(SortingAlgorithm<T> algorithm, Comparator<? super T> comparator);
}
