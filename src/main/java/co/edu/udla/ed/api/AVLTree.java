package co.edu.udla.ed.api;

import java.util.List;

/**
 * AVL Tree is a self-balancing binary search tree where the difference in
 * heights between the left and right subtrees of any node is at most one. This
 * property ensures that the tree remains balanced, providing efficient search,
 * insertion, and deletion operations with logarithmic time complexity.
 *
 * The AVLTree interface defines the operations that can be performed on an AVL
 * tree, including inserting values, checking for the presence of a value,
 * removing values, calculating the size and height of the tree, performing an
 * in-order traversal, and clearing the tree.
 *
 * @param <T> the type of elements stored in the AVL tree, which must be
 *            comparable to ensure proper ordering.
 */
public interface AVLTree<T extends Comparable<T>> {

  void insert(T value);

  boolean contains(T value);

  boolean remove(T value);

  int size();

  int height(); // vacío=0, solo raíz=1

  List<T> inOrder(); // debe salir ordenado

  void clear();

  /**
   * Checks if the AVL tree is empty.
   *
   * @return true if the tree is empty, false otherwise.
   */
  default boolean isEmpty() {
    return size() == 0;
  }

}
