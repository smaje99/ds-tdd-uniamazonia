package co.edu.udla.ed.api;

public interface CircularList<T> extends Iterable<T> {
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
