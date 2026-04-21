package co.edu.udla.ed.api;

import java.util.List;

/**
 * Observable contract for a red-black tree.
 *
 * @param <T> the comparable element type
 */
public interface RedBlackTree<T extends Comparable<T>> {

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
