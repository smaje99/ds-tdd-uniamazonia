package co.edu.udla.ed.api;

import java.util.Comparator;

/**
 * A simple list interface that defines basic operations for a list data
 * structure.
 *
 * @param <T> the type of elements in this list
 */
public interface SimpleList<T> extends List<T> {

  @Override
  SimpleList<T> sorted(SortingAlgorithm<T> algorithm);

  @Override
  SimpleList<T> sorted(SortingAlgorithm<T> algorithm, Comparator<? super T> comparator);
}
