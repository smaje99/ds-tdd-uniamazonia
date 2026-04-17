package co.edu.udla.ed.impl.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import co.edu.udla.ed.api.BinaryTree;

/**
 * Binary-tree implementation that stores explicit nodes and uses Java
 * collections for traversals.
 *
 * <p>
 * Unlike the wrappers that simply delegate to a JDK collection, this class
 * keeps a real binary-tree node structure because the API exposes node
 * references through {@link Node}. Java collections are used only as temporary
 * workspaces for iterative traversals such as level-order traversal.
 * </p>
 *
 * @param <T> the element type
 */
public class CollectionsBinaryTree<T> implements BinaryTree<T> {

  /**
   * Mutable node implementation used internally by this tree.
   *
   * <p>
   * Each node stores one value plus references to at most two children. The
   * node itself does not know its parent, which keeps the representation
   * minimal for teaching purposes.
   * </p>
   */
  private static final class MutableNode<T> implements Node<T> {
    private final T value;
    private MutableNode<T> left;
    private MutableNode<T> right;

    private MutableNode(T value) {
      this.value = value;
    }

    @Override
    public T value() {
      return value;
    }

    @Override
    public Node<T> left() {
      return left;
    }

    @Override
    public Node<T> right() {
      return right;
    }
  }

  private MutableNode<T> root;
  private int size;

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public Node<T> root() {
    return root;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * If a previous tree existed, this method replaces it with a new singleton
   * tree whose root stores {@code value}.
   * </p>
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public Node<T> makeRoot(T value) {
    root = new MutableNode<>(value);
    size = 1;
    return root;
  }

  /**
   * {@inheritDoc}
   *
   * @throws IllegalArgumentException if {@code parent} is {@code null} or does
   *         not belong to this tree
   * @throws IllegalStateException if the parent already has a left child
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public Node<T> attachLeft(Node<T> parent, T value) {
    MutableNode<T> node = cast(parent);
    if (node.left != null) {
      throw new IllegalStateException("left child already exists.");
    }
    node.left = new MutableNode<>(value);
    size++;
    return node.left;
  }

  /**
   * {@inheritDoc}
   *
   * @throws IllegalArgumentException if {@code parent} is {@code null} or does
   *         not belong to this tree
   * @throws IllegalStateException if the parent already has a right child
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public Node<T> attachRight(Node<T> parent, T value) {
    MutableNode<T> node = cast(parent);
    if (node.right != null) {
      throw new IllegalStateException("right child already exists.");
    }
    node.right = new MutableNode<>(value);
    size++;
    return node.right;
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * Height follows the repository convention: empty tree {@code 0}, root-only
   * tree {@code 1}.
   * </p>
   *
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public int height() {
    return height(root);
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public List<T> preOrder() {
    List<T> out = new ArrayList<>();
    preOrder(root, out);
    return out;
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public List<T> inOrder() {
    List<T> out = new ArrayList<>();
    inOrder(root, out);
    return out;
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public List<T> postOrder() {
    List<T> out = new ArrayList<>();
    postOrder(root, out);
    return out;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * This traversal uses a queue so nodes are reported level by level from left
   * to right.
   * </p>
   *
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public List<T> levelOrder() {
    List<T> out = new ArrayList<>();
    if (root == null) {
      return out;
    }

    Deque<MutableNode<T>> queue = new ArrayDeque<>();
    queue.addLast(root);
    while (!queue.isEmpty()) {
      MutableNode<T> current = queue.removeFirst();
      out.add(current.value);
      if (current.left != null) {
        queue.addLast(current.left);
      }
      if (current.right != null) {
        queue.addLast(current.right);
      }
    }
    return out;
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(1)} because the tree drops its root
   *           reference and resets the size counter.
   */
  @Override
  public void clear() {
    root = null;
    size = 0;
  }

  private int height(MutableNode<T> node) {
    if (node == null) {
      return 0;
    }
    return 1 + Math.max(height(node.left), height(node.right));
  }

  private void preOrder(MutableNode<T> node, List<T> out) {
    if (node == null) {
      return;
    }
    out.add(node.value);
    preOrder(node.left, out);
    preOrder(node.right, out);
  }

  private void inOrder(MutableNode<T> node, List<T> out) {
    if (node == null) {
      return;
    }
    inOrder(node.left, out);
    out.add(node.value);
    inOrder(node.right, out);
  }

  private void postOrder(MutableNode<T> node, List<T> out) {
    if (node == null) {
      return;
    }
    postOrder(node.left, out);
    postOrder(node.right, out);
    out.add(node.value);
  }

  @SuppressWarnings("unchecked")
  private MutableNode<T> cast(Node<T> parent) {
    if (parent == null) {
      throw new IllegalArgumentException("parent is null.");
    }
    if (!(parent instanceof MutableNode<?>)) {
      throw new IllegalArgumentException("Node does not belong to this tree.");
    }
    return (MutableNode<T>) parent;
  }

}
