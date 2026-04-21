package co.edu.udla.ed.api;

import java.util.Comparator;

/**
 * A list interface that defines basic operations for a list data structure.
 *
 * @param <T> the type of elements in this list
 */
public interface List<T> extends Iterable<T> {

  void addFirst(T element);

  void addLast(T element);

  T removeFirst();

  T removeLast();

  T get(int index);

  void set(int index, T element);

  boolean contains(T element);

  int size();

  default boolean isEmpty() {
    return size() == 0;
  }

  void clear();

  List<T> sorted(SortingAlgorithm<T> algorithm);

  List<T> sorted(SortingAlgorithm<T> algorithm, Comparator<? super T> comparator);

}
