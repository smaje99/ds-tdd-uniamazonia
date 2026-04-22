package co.edu.udla.ed.api;

import java.util.List;

/**
 * Interface for a binary tree data structure, where each node has at most two
 * children (left and right). The tree supports various operations such as
 * adding nodes, traversing the tree in different orders, and calculating the
 * size and height of the tree.
 *
 * @param <T> the type of values stored in the tree
 */
public interface BinaryTree<T> {

  /**
   * Read-only view of a binary-tree node.
   *
   * @param <T> value type stored in the node
   */
  interface Node<T> {
    T value();

    Node<T> left();

    Node<T> right();
  }

  Node<T> root();

  Node<T> makeRoot(T value);

  Node<T> attachLeft(Node<T> parent, T value);

  Node<T> attachRight(Node<T> parent, T value);

  int size();

  /**
   * Returns the height of the tree measured in levels.
   *
   * @return {@code 0} when the tree is empty, {@code 1} when it only contains
   *         the root, or the maximum number of levels on any root-to-leaf path
   */
  int height();

  List<T> preOrder();

  default Iterable<T> preOrderIterable() {
    return preOrder();
  }

  List<T> inOrder();

  default Iterable<T> inOrderIterable() {
    return inOrder();
  }

  List<T> postOrder();

  default Iterable<T> postOrderIterable() {
    return postOrder();
  }

  List<T> levelOrder();

  default Iterable<T> levelOrderIterable() {
    return levelOrder();
  }

  void clear();

  /**
   * Check if the tree is empty (i.e., has no nodes).
   *
   * @return true if the tree is empty, false otherwise
   */
  default boolean isEmpty() {
    return root() == null;
  }

}
