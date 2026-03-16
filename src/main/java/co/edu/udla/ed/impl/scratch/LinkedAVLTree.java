package co.edu.udla.ed.impl.scratch;

import java.util.ArrayList;
import java.util.List;

import co.edu.udla.ed.api.AVLTree;

/**
 * LinkedAVLTree is an implementation of the AVLTree interface using a linked
 * structure. It maintains the properties of an AVL tree, ensuring that the
 * tree remains balanced after insertions and deletions. The class provides
 * methods for inserting values, checking for the presence of values, removing
 * values, calculating the size and height of the tree, performing in-order
 * traversal, and clearing the tree.
 *
 * @param <T> the type of elements stored in the AVL tree, which must be
 *            comparable to ensure proper ordering.
 */
public class LinkedAVLTree<T extends Comparable<T>> implements AVLTree<T> {

  /**
   * Node class representing a node in the AVL tree. Each node contains a value,
   * references to its left and right children, and the height of the node. The
   * height is used to maintain the balance of the AVL tree, where a leaf node has
   * a height of 1.
   *
   * @param <T> the type of the value stored in the node, which must be comparable
   *            to maintain the AVL tree properties.
   */
  private static class Node<T> {
    T value;
    Node<T> left;
    Node<T> right;
    int height; // altura del nodo (leaf=1)

    Node(T value) {
      this.value = value;
      this.height = 1;
    }
  }

  private Node<T> root;
  private int size;

  /**
   * Inserts a value into the AVL tree. If the value already exists, it is
   * ignored. After insertion, the tree is rebalanced to maintain the AVL
   * properties. The size of the tree is updated only if a new node is created
   * (i.e., when inserting a non-duplicate value). This operation has a time
   * complexity of O(log n) due to the balancing steps involved.
   *
   * @param value the value to be inserted into the AVL tree
   */
  @Override
  public void insert(T value) {
    int before = size;
    root = insert(root, value);
    // size solo cambia si se insertó
    // (insert incrementa size cuando crea un nodo)
  }

  /**
   * Inserts a value into the subtree rooted at the given node. If the node is
   * null, a new node is created with the given value. If the value is less than
   * the node's value, it is inserted into the left subtree; if greater, it is
   * inserted into the right subtree. If the value is equal to the node's value,
   * it is considered a duplicate and is ignored. After the insertion, the height
   * of the node is updated, and the subtree is rebalanced if necessary to
   * maintain the AVL tree properties. The method returns the new root of the
   * subtree after insertion and rebalancing.
   *
   * @param node  the root of the subtree into which to insert
   * @param value the value to be inserted
   * @return the root of the updated subtree
   */
  private Node<T> insert(Node<T> node, T value) {
    if (node == null) {
      size++;
      return new Node<>(value);
    }

    int cmp = value.compareTo(node.value);
    if (cmp < 0)
      node.left = insert(node.left, value);
    else if (cmp > 0)
      node.right = insert(node.right, value);
    else
      return node; // duplicado: ignorar

    updateHeight(node);
    return rebalance(node);
  }

  /**
   * Checks if the AVL tree contains a specific value. The method traverses the
   * tree starting from the root, comparing the target value with the current
   * node's value. If the target value is less than the current node's value, it
   * continues searching in the left subtree; if greater, it continues in the
   * right subtree. If a match is found, it returns true. If the search reaches a
   * null node, it means the value is not present in the tree, and it returns
   * false. This operation has a time complexity of O(log n) in a balanced AVL
   * tree.
   *
   * @param value the value to search for in the AVL tree
   * @return true if the value is found in the tree, false otherwise
   */
  @Override
  public boolean contains(T value) {
    Node<T> cur = root;
    while (cur != null) {
      int cmp = value.compareTo(cur.value);
      if (cmp < 0)
        cur = cur.left;
      else if (cmp > 0)
        cur = cur.right;
      else
        return true;
    }
    return false;
  }

  /**
   * Removes a value from the AVL tree. The method first checks if the value
   * exists in the tree. If it does, it proceeds to remove the node containing the
   * value while maintaining the AVL tree properties. The removal process involves
   * finding the node to be removed, handling three cases (no children, one child,
   * or two children), and then rebalancing the tree if necessary. The size of the
   * tree is updated only if a node is actually removed. The method returns true
   * if the value was found and removed, and false if the value was not found in
   * the tree. This operation has a time complexity of O(log n) in a balanced AVL
   * tree due to the need to maintain balance after removal.
   *
   * @param value the value to be removed from the AVL tree
   * @return true if the value was found and removed, false otherwise
   */
  @Override
  public boolean remove(T value) {
    int before = size;
    root = remove(root, value);
    return size < before;
  }

  /**
   * Removes a value from the subtree rooted at the given node. The method
   * searches for the node containing the value to be removed. If the node is
   * found, it handles three cases: if the node has no children, it simply removes
   * it; if it has one child, it replaces the node with its child; if it has two
   * children, it finds the successor (the minimum node in the right subtree),
   * replaces the current node's value with the successor's value, and then
   * removes the successor node. After removal, it updates the height of the
   * current node and rebalances the subtree if necessary to maintain AVL tree
   * properties. The method returns the new root of the subtree after removal and
   * rebalancing.
   *
   * @param node  the root of the subtree from which to remove
   * @param value the value to be removed
   * @return the root of the updated subtree
   */
  private Node<T> remove(Node<T> node, T value) {
    if (node == null)
      return null;

    int cmp = value.compareTo(node.value);
    if (cmp < 0) {
      node.left = remove(node.left, value);
    } else if (cmp > 0) {
      node.right = remove(node.right, value);
    } else {
      // encontrado
      size--;

      // 0 o 1 hijo
      if (node.left == null)
        return node.right;
      if (node.right == null)
        return node.left;

      // 2 hijos: usar sucesor (mínimo del subárbol derecho)
      Node<T> successorNode = min(node.right);
      node.value = successorNode.value;

      // eliminar el sucesor real: OJO, aquí size-- ocurriría de nuevo,
      // por eso usamos removeMin que NO decrementa size (ya lo hicimos).
      node.right = removeMin(node.right);
    }

    // si quedó null (p.ej. borramos hoja) terminar
    if (node == null)
      return null;

    updateHeight(node);
    return rebalance(node);
  }

  /**
   * Returns the minimum node in the subtree rooted at the given node. The minimum
   * node is found by traversing the left child nodes until a leaf node is
   * reached. This method is used during the removal process to find the successor
   * of a node that has two children. The time complexity of this operation is
   * O(log n) in a balanced AVL tree, as it may require traversing down to the
   * leaf level in the worst case.
   *
   * @param node the root of the subtree
   * @return the minimum node in the subtree
   */
  private Node<T> min(Node<T> node) {
    Node<T> currentNode = node;
    while (currentNode.left != null)
      currentNode = currentNode.left;
    return currentNode;
  }

  /**
   * Removes the minimum node from the subtree rooted at the given node. This
   * method is used during the removal process when a node with two children is
   * removed and its successor (the minimum node in the right subtree) needs to be
   * removed. The method traverses down the left child nodes until it finds the
   * minimum node, and then removes it by returning its right child (which may be
   * null). After removal, it updates the height of the current node and
   * rebalances the subtree if necessary to maintain AVL tree properties. The time
   * complexity of this operation is O(log n) in a balanced AVL tree.
   *
   * @param node the root of the subtree from which to remove the minimum node
   * @return the root of the updated subtree after removing the minimum node
   */
  private Node<T> removeMin(Node<T> node) {
    // Elimina el nodo mínimo de este subárbol SIN tocar size (ya se ajustó)
    if (node.left == null) {
      return node.right;
    }
    node.left = removeMin(node.left);
    updateHeight(node);
    return rebalance(node);
  }

  /**
   * Returns the number of elements in the AVL tree. The size is maintained as an
   * instance variable that is updated during insertions and removals. This allows
   * the size method to return the number of elements in constant time O(1), as it
   * simply returns the value of the size variable without needing to traverse the
   * tree.
   *
   * @return the number of elements currently in the AVL tree
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Returns the height of the AVL tree. The height is calculated as the maximum
   * height of the left and right subtrees of the root node. An empty tree has a
   * height of 0. A tree with only a root node has a height of 1. The height is
   * maintained as an instance variable in each node, which is updated during
   * insertions and removals. This allows the height method to return the height
   * of the tree in constant time O(1) by simply returning the height of the root
   * node.
   *
   * @return the height of the AVL tree
   */
  @Override
  public int height() {
    return h(root);
  }

  @Override
  public List<T> inOrder() {
    List<T> out = new ArrayList<>();
    inOrder(root, out);
    return out;
  }

  /**
   * Performs an in-order traversal of the AVL tree and adds the values to the
   * given list. The in-order traversal visits the left subtree, the current node,
   * and then the right subtree, resulting in a sorted order of values. The method
   * is called recursively for each node in the tree, starting from the root. If
   * the current node is null, it simply returns without adding anything to the
   * list. This operation has a time complexity of O(n), where n is the number of
   * nodes in the tree, as it visits each node exactly once.
   *
   * @param currentNode the current node in the traversal
   * @param out         the list to which values are added
   */
  private void inOrder(Node<T> currentNode, List<T> out) {
    if (currentNode == null)
      return;
    inOrder(currentNode.left, out);
    out.add(currentNode.value);
    inOrder(currentNode.right, out);
  }

  /**
   * Clears the AVL tree, removing all nodes and resetting the size to zero. The
   * method sets the root of the tree to null, effectively removing all references
   * to the existing nodes, which allows them to be garbage collected. The size
   * variable is also reset to zero to reflect that the tree is now empty. This
   * operation has a time complexity of O(1) since it simply updates the root
   * reference and size variable without needing to traverse the tree
   */
  @Override
  public void clear() {
    root = null;
    size = 0;
  }

  // ---- AVL helpers ----

  /**
   * Returns the height of the given node. If the node is null, returns 0.
   *
   * @param n the node for which to get the height
   * @return the height of the node or 0 if null
   */
  private int h(Node<T> n) {
    return n == null ? 0 : n.height;
  }

  /**
   * Updates the height of the given node based on the heights of its children.
   *
   * @param n the node for which to update the height
   */
  private void updateHeight(Node<T> n) {
    n.height = 1 + Math.max(h(n.left), h(n.right));
  }

  /**
   * Returns the balance factor of the given node. The balance factor is the
   * difference between the heights of the left and right subtrees.
   *
   * @param n the node for which to get the balance factor
   * @return the balance factor of the node
   */
  private int balanceFactor(Node<T> n) {
    return h(n.left) - h(n.right);
  }

  /**
   * Rebalances the given node if it is unbalanced. It checks the balance factor
   * and performs the necessary rotations to maintain the AVL tree properties.
   *
   * @param n the node to rebalance
   * @return the new root of the subtree after rebalancing
   */
  private Node<T> rebalance(Node<T> n) {
    int bf = balanceFactor(n);

    // Left heavy
    if (bf > 1) {
      if (balanceFactor(n.left) < 0) {
        // LR
        n.left = rotateLeft(n.left);
      }
      // LL
      return rotateRight(n);
    }

    // Right heavy
    if (bf < -1) {
      if (balanceFactor(n.right) > 0) {
        // RL
        n.right = rotateRight(n.right);
      }
      // RR
      return rotateLeft(n);
    }

    return n; // balanced
  }

  /**
   * Performs a right rotation on the given node. This rotation is used to balance
   * the tree when the left subtree is heavier than the right subtree.
   *
   * @param y the node to rotate
   * @return the new root of the subtree after rotation
   */
  private Node<T> rotateRight(Node<T> y) {
    Node<T> x = y.left;
    Node<T> t2 = x.right;

    // rotate
    x.right = y;
    y.left = t2;

    // update heights
    updateHeight(y);
    updateHeight(x);

    return x;
  }

  /**
   * Performs a left rotation on the given node. This rotation is used to balance
   * the tree when the right subtree is heavier than the left subtree.
   *
   * @param x the node to rotate
   * @return the new root of the subtree after rotation
   */
  private Node<T> rotateLeft(Node<T> x) {
    Node<T> y = x.right;
    Node<T> t2 = y.left;

    // rotate
    y.left = x;
    x.right = t2;

    // update heights
    updateHeight(x);
    updateHeight(y);

    return y;
  }

}
