package co.edu.udla.ed.api;

import java.util.List;

/**
 * Observable contract for a B-Tree.
 *
 * @param <T> the comparable element type
 */
public interface BTree<T extends Comparable<T>> {

  void insert(T value);

  boolean contains(T value);

  boolean remove(T value);

  int size();

  int height();

  List<T> inOrder();

  default Iterable<T> inOrderIterable() {
    return inOrder();
  }

  void clear();

  default boolean isEmpty() {
    return size() == 0;
  }

}
