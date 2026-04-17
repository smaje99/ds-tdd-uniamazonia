package co.edu.udla.ed.impl.linear;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import co.edu.udla.ed.api.BinaryTree;

/**
 * Binary-tree implementation that favors explicit iterative traversals.
 *
 * <p>
 * The tree still stores real nodes because the public API exposes node
 * references. The "linear" emphasis appears in the traversal algorithms:
 * pre-order, in-order, post-order, level-order, and height are all expressed
 * with explicit iterative control structures instead of recursive helper
 * methods where that makes the traversal logic easier to inspect.
 * </p>
 *
 * @param <T> the element type
 */
public class LinearBinaryTree<T> implements BinaryTree<T> {

  /**
   * Mutable node implementation used by this tree.
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
   * Height is computed level by level with a queue, so the result still follows
   * the repository convention of counting levels rather than edges.
   * </p>
   *
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public int height() {
    if (root == null) {
      return 0;
    }

    Deque<MutableNode<T>> queue = new ArrayDeque<>();
    queue.addLast(root);
    int height = 0;
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      height++;
      for (int i = 0; i < levelSize; i++) {
        MutableNode<T> current = queue.removeFirst();
        if (current.left != null) {
          queue.addLast(current.left);
        }
        if (current.right != null) {
          queue.addLast(current.right);
        }
      }
    }
    return height;
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public List<T> preOrder() {
    List<T> out = new ArrayList<>();
    if (root == null) {
      return out;
    }

    Deque<MutableNode<T>> stack = new ArrayDeque<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      MutableNode<T> current = stack.pop();
      out.add(current.value);
      if (current.right != null) {
        stack.push(current.right);
      }
      if (current.left != null) {
        stack.push(current.left);
      }
    }
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
    Deque<MutableNode<T>> stack = new ArrayDeque<>();
    MutableNode<T> current = root;

    while (current != null || !stack.isEmpty()) {
      while (current != null) {
        stack.push(current);
        current = current.left;
      }
      MutableNode<T> node = stack.pop();
      out.add(node.value);
      current = node.right;
    }

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
    if (root == null) {
      return out;
    }

    Deque<MutableNode<T>> stack = new ArrayDeque<>();
    Deque<MutableNode<T>> reverse = new ArrayDeque<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      MutableNode<T> current = stack.pop();
      reverse.push(current);
      if (current.left != null) {
        stack.push(current.left);
      }
      if (current.right != null) {
        stack.push(current.right);
      }
    }

    while (!reverse.isEmpty()) {
      out.add(reverse.pop().value);
    }
    return out;
  }

  /**
   * {@inheritDoc}
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
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public void clear() {
    root = null;
    size = 0;
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
