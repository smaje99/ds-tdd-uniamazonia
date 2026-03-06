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

  // Nested interface for a node in the binary tree
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

  int height(); // altura en número de niveles: vacío=0, solo raíz=1

  List<T> preOrder();

  List<T> inOrder();

  List<T> postOrder();

  List<T> levelOrder();

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
