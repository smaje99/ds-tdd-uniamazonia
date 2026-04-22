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

  /**
   * Removes {@code value} when it exists in the tree.
   *
   * @param value value to remove
   * @return {@code true} if a node was removed; {@code false} if the value was
   *         not present
   */
  boolean remove(T value);

  int size();

  /**
   * Returns the height of the tree measured in levels.
   *
   * @return {@code 0} when the tree is empty, {@code 1} when it only contains
   *         the root, or the maximum number of levels on any root-to-leaf path
   */
  int height();

  /**
   * Returns the values in ascending order according to the BST invariant.
   *
   * @return an in-order traversal of the tree
   */
  List<T> inOrder();

  default Iterable<T> inOrderIterable() {
    return inOrder();
  }

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
