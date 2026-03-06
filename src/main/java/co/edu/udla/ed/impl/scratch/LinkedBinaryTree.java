package co.edu.udla.ed.impl.scratch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import co.edu.udla.ed.api.BinaryTree;

/**
 * Implementation of a binary tree data structure using linked nodes. Each node
 * contains a value and references to its left and right child nodes. The tree
 * supports various operations such as adding nodes, traversing the tree in
 * different orders, and calculating the size and height of the tree.
 *
 * @param <T> the type of values stored in the tree
 */
public class LinkedBinaryTree<T> implements BinaryTree<T> {

  /**
   * Private static inner class that implements the Node interface for the binary
   * tree. Each node contains a value of type T and references to the left and
   * right child nodes.
   *
   * @param <T> the type of value stored in the node
   */
  private static class NodeImpl<T> implements Node<T> {
    private final T value;
    private NodeImpl<T> left;
    private NodeImpl<T> right;

    NodeImpl(T value) {
      this.value = value;
    }

    @Override
    public T value() {
      return value;
    }

    /**
     * Returns the left child of this node. If there is no left child, returns null.
     *
     * @return the left child node, or null if there is no left child
     */
    @Override
    public Node<T> left() {
      return left;
    }

    /**
     * Returns the right child of this node. If there is no right child, returns
     * null.
     *
     * @return the right child node, or null if there is no right child
     */
    @Override
    public Node<T> right() {
      return right;
    }
  }

  private NodeImpl<T> root;
  private int size;

  /**
   * Returns the root node of the binary tree. If the tree is empty, returns null.
   *
   * @return the root node of the tree, or null if the tree is empty
   */
  @Override
  public Node<T> root() {
    return root;
  }

  /**
   * Creates a new root node with the specified value and sets it as the root of
   * the tree. If the tree already has a root, it will be replaced by the new root
   * node.
   *
   * @param value the value to be stored in the new root node
   * @return the newly created root node
   */
  @Override
  public Node<T> makeRoot(T value) {
    root = new NodeImpl<>(value);
    size = 1;
    return root;
  }

  /**
   * Attaches a new left child node with the specified value to the given parent
   * node. If the parent node already has a left child, an
   * IllegalStateException is thrown. If the parent node is null, an
   * IllegalArgumentException is thrown. This operation runs in constant time O(1)
   * since it only involves updating the reference to the left child and
   * incrementing the size of the tree.
   *
   * @param parent the parent node to which the new left child will be attached
   * @param value  the value to be stored in the new left child node
   * @return the newly created left child node
   * @throws IllegalArgumentException if the parent node is null
   * @throws IllegalStateException    if the parent node already has a left child
   */
  @Override
  public Node<T> attachLeft(Node<T> parent, T value) {
    if (parent == null)
      throw new IllegalArgumentException("parent is null.");
    NodeImpl<T> p = cast(parent);
    if (p.left != null)
      throw new IllegalStateException("left child already exists.");
    p.left = new NodeImpl<>(value);
    size++;
    return p.left;
  }

  /**
   * Attaches a new right child node with the specified value to the given parent
   * node. If the parent node already has a right child, an
   * IllegalStateException is thrown. If the parent node is null, an
   * IllegalArgumentException is thrown. This operation runs in constant time O(1)
   * since it only involves updating the reference to the right child and
   * incrementing the size of the tree.
   *
   * @param parent the parent node to which the new right child will be attached
   * @param value  the value to be stored in the new right child node
   * @return the newly created right child node
   * @throws IllegalArgumentException if the parent node is null
   * @throws IllegalStateException    if the parent node already has a right child
   */
  @Override
  public Node<T> attachRight(Node<T> parent, T value) {
    if (parent == null)
      throw new IllegalArgumentException("parent is null.");
    NodeImpl<T> p = cast(parent);
    if (p.right != null)
      throw new IllegalStateException("right child already exists.");
    p.right = new NodeImpl<>(value);
    size++;
    return p.right;
  }

  /**
   * Returns the number of nodes in the binary tree. The size is updated whenever
   * a new node is added to the tree, so this method runs in constant time O(1).
   *
   * @return the number of nodes in the tree
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Returns the height of the binary tree, which is defined as the number of
   * levels in the tree. An empty tree has a height of 0, and a tree with only a
   * root node has a height of 1. This method uses a helper method to calculate
   * the height recursively by finding the maximum height of the left and right
   * subtrees and adding 1 for the current node. The time complexity of this
   * method is O(n) in the worst case, where n is the number of nodes in the tree,
   * because it may need to visit every node to calculate the height.
   *
   * @return the height of the tree
   */
  @Override
  public int height() {
    return height(root);
  }

  /**
   * Returns a list of the values of the nodes in the binary tree in pre-order
   * traversal order. In pre-order traversal, the current node is visited first,
   * followed by the left subtree and then the right subtree. This method uses a
   * helper method to perform the pre-order traversal recursively and add the
   * values to a list. The time complexity of this method is O(n) because it
   * visits each node exactly once.
   *
   * @return a list of the values of the nodes in pre-order traversal order
   */
  @Override
  public List<T> preOrder() {
    final List<T> out = new ArrayList<>();
    preOrder(root, out);
    return out;
  }

  /**
   * Returns a list of the values of the nodes in the binary tree in in-order
   * traversal order. In in-order traversal, the left subtree is visited first,
   * followed by the current node and then the right subtree. This method uses a
   * helper method to perform the in-order traversal recursively and add the
   * values to a list. The time complexity of this method is O(n) because it
   * visits each node exactly once.
   *
   * @return a list of the values of the nodes in in-order traversal order
   */
  @Override
  public List<T> inOrder() {
    final List<T> out = new ArrayList<>();
    inOrder(root, out);
    return out;
  }

  /**
   * Returns a list of the values of the nodes in the binary tree in post-order
   * traversal order. In post-order traversal, the left subtree is visited first,
   * followed by the right subtree and then the current node. This method uses a
   * helper method to perform the post-order traversal recursively and add the
   * values to a list. The time complexity of this method is O(n) because it
   * visits each node exactly once.
   *
   * @return a list of the values of the nodes in post-order traversal order
   */
  @Override
  public List<T> postOrder() {
    final List<T> out = new ArrayList<>();
    postOrder(root, out);
    return out;
  }

  /**
   * Returns a list of the values of the nodes in the binary tree in level-order
   * traversal order. In level-order traversal, the nodes are visited level by
   * level from left to right. This method uses a queue to perform the
   * level-order traversal iteratively. It starts by adding the root node to the
   * queue, and then it repeatedly removes nodes from the front of the queue,
   * adds their values to the output list, and adds their left and right children
   * to the back of the queue until the queue is empty. The time complexity of
   * this method is O(n) because it visits each node exactly once.
   *
   * @return a list of the values of the nodes in level-order traversal order
   */
  @Override
  public List<T> levelOrder() {
    List<T> out = new ArrayList<>();
    if (root == null)
      return out;

    Deque<NodeImpl<T>> q = new ArrayDeque<>();
    q.add(root);

    while (!q.isEmpty()) {
      NodeImpl<T> n = q.removeFirst();
      out.add(n.value);
      if (n.left != null)
        q.addLast(n.left);
      if (n.right != null)
        q.addLast(n.right);
    }

    return out;
  }

  /**
   * Clears the binary tree by setting the root to null and resetting the size to
   * 0. This effectively removes all nodes from the tree and allows it to be
   * reused. The time complexity of this method is O(1) since it only involves
   * updating a couple of references and resetting a counter.
   */
  @Override
  public void clear() {
    root = null;
    size = 0;
  }

  /**
   * Helper method to calculate the height of the binary tree starting from a
   * given node. The height is defined as the number of levels in the tree, where
   * an empty tree has a height of 0 and a tree with only a root node has a height
   * of 1. This method uses recursion to calculate the height by finding the
   * maximum height of the left and right subtrees and adding 1 for the current
   * node.
   *
   * @param n the node from which to calculate the height
   * @return the height of the subtree rooted at the given node
   */
  private int height(NodeImpl<T> n) {
    if (n == null)
      return 0;
    return 1 + Math.max(height(n.left), height(n.right));
  }

  /**
   * Helper method to perform a pre-order traversal of the binary tree. This
   * method takes a node and a list as parameters, and it recursively visits the
   * current node, adds its value to the list, and then visits the left and right
   * child nodes.
   *
   * @param n   the current node being visited
   * @param out the list to which the values of the nodes will be added in
   *            pre-order
   */
  private void preOrder(NodeImpl<T> n, List<T> out) {
    if (n == null)
      return;
    out.add(n.value);
    preOrder(n.left, out);
    preOrder(n.right, out);
  }

  /**
   * Helper method to perform an in-order traversal of the binary tree. This
   * method takes a node and a list as parameters, and it recursively visits the
   * left child node, adds the value of the current node to the list, and then
   * visits the right child node.
   *
   * @param n   the current node being visited
   * @param out the list to which the values of the nodes will be added in
   *            in-order
   */
  private void inOrder(NodeImpl<T> n, List<T> out) {
    if (n == null)
      return;
    inOrder(n.left, out);
    out.add(n.value);
    inOrder(n.right, out);
  }

  /**
   * Helper method to perform a post-order traversal of the binary tree. This
   * method takes a node and a list as parameters, and it recursively visits the
   * left and right child nodes before adding the value of the current node to the
   * list.
   *
   * @param n   the current node being visited
   * @param out the list to which the values of the nodes will be added in
   *            post-order
   */
  private void postOrder(NodeImpl<T> n, List<T> out) {
    if (n == null)
      return;
    postOrder(n.left, out);
    postOrder(n.right, out);
    out.add(n.value);
  }

  /**
   * Helper method to cast a Node<T> to a NodeImpl<T>. This method checks if the
   * given node is an instance of NodeImpl<?> and throws an
   * IllegalArgumentException if it is not. If the node is valid, it performs an
   * unchecked cast to NodeImpl<T> and returns the casted node.
   *
   * @param n the node to be casted
   * @return the casted node as NodeImpl<T>
   * @throws IllegalArgumentException if the node is not an instance of
   *                                  NodeImpl<?>
   */
  private NodeImpl<T> cast(Node<T> n) {
    if (!(n instanceof NodeImpl<?>))
      throw new IllegalArgumentException("Node not from this tree.");

    return (NodeImpl<T>) n;
  }

}
