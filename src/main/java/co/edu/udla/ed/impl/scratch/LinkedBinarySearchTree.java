package co.edu.udla.ed.impl.scratch;

import java.util.ArrayList;
import java.util.List;

import co.edu.udla.ed.api.BinarySearchTree;

public class LinkedBinarySearchTree<T extends Comparable<T>> implements BinarySearchTree<T> {

  /**
   * Node class represents a single node in the binary search tree, containing a
   * value and references to the left and right child nodes.
   *
   * @param <T> the type of value stored in the node, which must be comparable to
   *            maintain the properties of the binary search tree.
   */
  private static class Node<T> {
    T value;
    Node<T> left;
    Node<T> right;

    Node(T value) {
      this.value = value;
    }
  }

  private Node<T> root;
  private int size;

  /**
   * Inserts a value into the binary search tree. If the value already exists, it
   * is ignored (no duplicates allowed). The method traverses the tree to find the
   * correct position for the new value, maintaining the properties of the binary
   * search tree. This implementation does not allow duplicate values, and the
   * size of the tree is only incremented when a new value is successfully
   * inserted.
   *
   * This operation has an average time complexity of O(log n) for balanced trees,
   * but can degrade to O(n) in the worst case (e.g., when the tree becomes a
   * linked list).
   *
   * @param value the value to be inserted into the tree.
   */
  @Override
  public void insert(T value) {
    if (root == null) {
      root = new Node<>(value);
      size = 1;
      return;
    }

    Node<T> currentNode = root;
    while (true) {
      int comparisonResult = value.compareTo(currentNode.value);
      if (comparisonResult < 0) {
        if (currentNode.left == null) {
          currentNode.left = new Node<>(value);
          size++;
          return;
        }
        currentNode = currentNode.left;
      } else if (comparisonResult > 0) {
        if (currentNode.right == null) {
          currentNode.right = new Node<>(value);
          size++;
          return;
        }
        currentNode = currentNode.right;
      } else {
        // duplicado: decisión didáctica -> ignorar (no incrementa size)
        return;
      }
    }
  }

  /**
   * Checks if a value is present in the binary search tree. The method traverses
   * the tree, comparing the target value with the values of the nodes. If the
   * target value is less than the current node's value, it continues searching in
   * the left subtree; if greater, it continues in the right subtree. If a match
   * is found, it returns true; if the search reaches a null node, it returns
   * false. This operation has an average time complexity of O(log n) for balanced
   * trees, but can degrade to O(n) in the worst case.
   */
  @Override
  public boolean contains(T value) {
    Node<T> currentNode = root;
    while (currentNode != null) {
      int comparisonResult = value.compareTo(currentNode.value);
      if (comparisonResult < 0)
        currentNode = currentNode.left;
      else if (comparisonResult > 0)
        currentNode = currentNode.right;
      else
        return true;
    }
    return false;
  }

  /**
   * Removes a value from the binary search tree. The method first searches for
   * the node containing the target value. If the node is found, it handles three
   * cases:
   * 1) The node has no children: it can simply be removed by returning null.
   * 2) The node has one child: it can be removed by returning its non-null child,
   * effectively bypassing the node.
   * 3) The node has two children: it is replaced with its in-order successor (the
   * minimum node in its right subtree), and then the successor node is removed
   * from the right subtree.
   *
   * The size of the tree is decremented only when a node
   * is actually removed, and care is taken to ensure that the size is not
   * decremented multiple times when handling the case of two children. This
   * operation has an average time complexity of O(log n) for balanced trees, but
   * can degrade to O(n) in the worst case.
   *
   * @param value the value to be removed from the tree.
   * @return true if the value was successfully removed, false if it was not
   *         found.
   */
  @Override
  public boolean remove(T value) {
    int before = size;
    root = remove(root, value);
    return size < before;
  }

  /**
   * Returns the number of elements currently stored in the binary search tree.
   * The size is maintained as a field that is updated during insertions and
   * removals, allowing this method to return the size in O(1) time. This approach
   * ensures that the size is always accurate and does not require traversing the
   * tree to count the nodes, which would be inefficient (O(n)) for large trees.
   *
   * @return the number of elements in the tree.
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Calculates the height of the binary search tree. The height is defined as the
   * number of edges on the longest path from the root to a leaf node. An empty
   * tree has a height of 0, and a tree with only a root node has a height of 1.
   * The method uses recursion to calculate the height of the left and right
   * subtrees and returns the maximum of the two heights plus one for the current
   * node. This operation has an average time complexity of O(n) since it needs to
   * visit each node in the tree to calculate the height.
   *
   * @return the height of the tree.
   */
  @Override
  public int height() {
    return height(root);
  }

  /**
   * Performs an in-order traversal of the binary search tree, which visits the
   * nodes in sorted order. The method uses recursion to traverse the left
   * subtree, adds the current node's value to the output list, and then
   * traverses the right subtree. The resulting list contains all values in the
   * tree in ascending order. This operation has a time complexity of O(n) since
   * it needs to visit each node in the tree exactly once.
   *
   * @return a list of values in the tree in sorted order.
   */
  @Override
  public List<T> inOrder() {
    List<T> out = new ArrayList<>();
    inOrder(root, out);
    return out;
  }

  /**
   * Clears the binary search tree by setting the root to null and resetting the
   * size to zero. This effectively removes all nodes from the tree, allowing for
   * garbage collection to reclaim the memory used by the nodes. After calling
   * this method, the tree will be empty, and any subsequent operations will
   * behave as if starting with a new tree. This operation has a time complexity of
   * O(1) since it does not require traversing the tree to remove nodes individually.
   */
  @Override
  public void clear() {
    root = null;
    size = 0;
  }

  /**
   * Removes a value from the binary search tree. The method first searches for
   * the node containing the target value. If the node is found, it handles three
   * cases:
   * 1) The node has no children: it can simply be removed by returning null.
   * 2) The node has one child: it can be removed by returning its non-null child,
   * effectively bypassing the node.
   * 3) The node has two children: it is replaced with its in-order successor (the
   * minimum node in its right subtree), and then the successor node is removed
   * from the right subtree.
   *
   * The size of the tree is decremented only when a node
   * is actually removed, and care is taken to ensure that the size is not
   * decremented multiple times when handling the case of two children. This
   * operation has an average time complexity of O(log n) for balanced trees, but
   * can degrade to O(n) in the worst case.
   *
   * @param subtreeRoot the root of the subtree being processed (initially the
   *                    root of the tree).
   * @param value       the value to be removed from the tree.
   * @return the new root of the subtree after removal.
   */
  private Node<T> remove(Node<T> subtreeRoot, T value) {
    if (subtreeRoot == null)
      return null;

    int cmp = value.compareTo(subtreeRoot.value);
    if (cmp < 0) {
      subtreeRoot.left = remove(subtreeRoot.left, value);
      return subtreeRoot;
    }
    if (cmp > 0) {
      subtreeRoot.right = remove(subtreeRoot.right, value);
      return subtreeRoot;
    }

    // encontrado
    size--;

    // caso 1: 0 hijos
    if (subtreeRoot.left == null && subtreeRoot.right == null)
      return null;

    // caso 2: 1 hijo
    if (subtreeRoot.left == null)
      return subtreeRoot.right;
    if (subtreeRoot.right == null)
      return subtreeRoot.left;

    // caso 3: 2 hijos -> reemplazar por sucesor (mínimo del subárbol derecho)
    Node<T> successorNode = min(subtreeRoot.right);
    subtreeRoot.value = successorNode.value;

    // ojo: aquí estamos eliminando el sucesor real sin decrementar size otra vez
    subtreeRoot.right = removeMin(subtreeRoot.right);
    size++; // compensación por el decremento extra dentro de removeMin
    return subtreeRoot;
  }

  /**
   * Finds the minimum node in a subtree.
   *
   * @param traversalNode the root of the subtree to search.
   * @return the minimum node in the subtree.
   */
  private Node<T> min(Node<T> traversalNode) {
    while (traversalNode.left != null)
      traversalNode = traversalNode.left;
    return traversalNode;
  }

  /**
   * Removes the minimum node from a subtree. This method is used when removing a
   * node with two children, where the in-order successor (the minimum node in the
   * right subtree) needs to be removed after its value has been copied to the
   * node being removed. The method traverses the left children of the subtree
   * until it finds the minimum node. If the minimum node has a right child, that
   * child is returned to replace the minimum node; if it has no children, null is
   * returned. The size of the tree is decremented only when the minimum node is
   * actually removed, ensuring that the size remains accurate when handling the
   * case of two children in the remove method. This operation has an average time
   * complexity of O(log n) for balanced trees,
   *
   *
   * @param subtreeRoot the root of the subtree from which to remove the minimum
   *                    node.
   * @return the new root of the subtree after removing the minimum node.
   */
  private Node<T> removeMin(Node<T> subtreeRoot) {
    if (subtreeRoot.left == null) {
      // este es el mínimo
      size--;
      return subtreeRoot.right;
    }
    subtreeRoot.left = removeMin(subtreeRoot.left);
    return subtreeRoot;
  }

  /**
   * Calculates the height of the binary search tree. The height is defined as the
   * number of edges on the longest path from the root to a leaf node. An empty
   * tree has a height of 0, and a tree with only a root node has a height of 1.
   * The method uses recursion to calculate the height of the left and right
   * subtrees and returns the maximum of the two heights plus one for the current
   * node. This operation has an average time complexity of O(n) since it needs to
   * visit each node in the tree to calculate the height.
   *
   * @return the height of the tree.
   */
  private int height(Node<T> n) {
    if (n == null)
      return 0;
    return 1 + Math.max(height(n.left), height(n.right));
  }

  /**
   * Performs an in-order traversal of the binary search tree, which visits the
   * nodes in sorted order. The method uses recursion to traverse the left
   * subtree, adds the current node's value to the output list, and then
   * traverses the right subtree. The resulting list contains all values in the
   * tree in ascending order. This operation has a time complexity of O(n) since
   * it needs to visit each node in the tree exactly once.
   *
   * @param traverseNode the current node being traversed (initially the root of
   *                     the tree).
   * @param out          the list to which the values will be added in sorted
   *                     order.
   */
  private void inOrder(Node<T> traverseNode, List<T> out) {
    if (traverseNode == null)
      return;
    inOrder(traverseNode.left, out);
    out.add(traverseNode.value);
    inOrder(traverseNode.right, out);
  }

}
