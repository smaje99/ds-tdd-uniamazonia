package co.edu.udla.ed.api;

import java.util.List;

/**
 * Binary Search Tree (BTS) is a binary tree where each node has a value, and
 * the value of each node is greater than the values of all nodes in its left
 * subtree and less than the values of all nodes in its right subtree. This
 * property allows for efficient searching, insertion, and deletion operations.
 *
 * The BinarySearchTree interface defines the operations that can be performed
 * on a binary search tree, including inserting values, checking for the
 * presence of a value, removing values, calculating the size and height of the
 * tree, performing an in-order traversal, and clearing the tree.
 *
 * @param <T> the type of elements stored in the binary search tree, which must
 *            be comparable to ensure proper ordering.
 */
public interface BinarySearchTree<T extends Comparable<T>> {

  void insert(T value);

  boolean contains(T value);

  boolean remove(T value); // true si eliminó, false si no estaba

  int size();

  int height(); // vacío=0, solo raíz=1

  List<T> inOrder(); // debe salir ordenado

  void clear();

  /**
   * Checks if the binary search tree is empty.
   *
   * @return true if the tree is empty, false otherwise.
   */
  default boolean isEmpty() {
    return size() == 0;
  }
}
