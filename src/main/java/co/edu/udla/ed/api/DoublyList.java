package co.edu.udla.ed.api;

/**
 * A doubly linked list interface that extends the SimpleList interface and
 * defines additional operations specific to a doubly linked list.
 *
 * @param <T> the type of elements in this list
 */
public interface DoublyList<T> extends Iterable<T> {

  void addFirst(T value);

  void addLast(T value);

  T removeFirst();

  T removeLast();

  T get(int index);

  boolean contains(T value);

  int size();

  default boolean isEmpty() {
    return size() == 0;
  }

  void clear();
}
