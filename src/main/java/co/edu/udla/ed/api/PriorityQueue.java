package co.edu.udla.ed.api;

/**
 * A minimum priority queue stores comparable values and always exposes the
 * smallest value first.
 *
 * @param <T> the comparable element type
 */
public interface PriorityQueue<T extends Comparable<T>> extends Iterable<T> {

  void insert(T value);

  T removeMin();

  T peekMin();

  int size();

  default boolean isEmpty() {
    return size() == 0;
  }

  void clear();

}
