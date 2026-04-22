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

  /**
   * Replaces the value at a zero-based index.
   *
   * @param index index to update
   * @param element replacement value
   * @throws IndexOutOfBoundsException if {@code index} is outside the current
   *         list bounds
   */
  void set(int index, T element);

  boolean contains(T element);

  int size();

  default boolean isEmpty() {
    return size() == 0;
  }

  void clear();

  /**
   * Returns a new list containing the same values sorted by natural ordering.
   *
   * @param algorithm sorting algorithm to apply to a copy of this list
   * @return a sorted list, leaving this list unchanged
   */
  List<T> sorted(SortingAlgorithm<T> algorithm);

  /**
   * Returns a new list containing the same values sorted by a comparator.
   *
   * @param algorithm sorting algorithm to apply to a copy of this list
   * @param comparator ordering strategy, or {@code null} for natural ordering
   * @return a sorted list, leaving this list unchanged
   */
  List<T> sorted(SortingAlgorithm<T> algorithm, Comparator<? super T> comparator);

}
