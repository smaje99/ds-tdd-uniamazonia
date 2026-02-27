package co.edu.udla.ed.api;

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

  boolean contains(T element);

  int size();

  default boolean isEmpty() {
    return size() == 0;
  }

  void clear();

}
