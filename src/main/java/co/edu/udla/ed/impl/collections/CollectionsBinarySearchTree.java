package co.edu.udla.ed.impl.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import co.edu.udla.ed.api.BinarySearchTree;
import co.edu.udla.ed.common.TreeHeights;

/**
 * BST adapter backed by {@link TreeSet}.
 *
 * <p>
 * This implementation preserves the public semantics of the repository BST API:
 * duplicate insertions are ignored, {@code contains} performs ordered lookup,
 * and {@code inOrder()} returns values in ascending order. Because
 * {@link TreeSet} does not expose its internal nodes, the reported height is an
 * educational estimate based on the number of stored elements rather than the
 * exact private shape of the JDK tree.
 * </p>
 *
 * @param <T> the element type
 */
public class CollectionsBinarySearchTree<T extends Comparable<T>> implements BinarySearchTree<T> {

  private final TreeSet<T> data = new TreeSet<>();

  /**
   * {@inheritDoc}
   *
   * <p>
   * If the value already exists, the underlying set keeps only one copy, which
   * matches the repository rule that BST duplicates are ignored.
   * </p>
   *
   * @implNote Time complexity is {@code O(log n)}.
   */
  @Override
  public void insert(T value) {
    data.add(value);
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(log n)}.
   */
  @Override
  public boolean contains(T value) {
    return data.contains(value);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The method returns {@code true} only when the value was present and was
   * actually removed from the tree.
   * </p>
   *
   * @implNote Time complexity is {@code O(log n)}.
   */
  @Override
  public boolean remove(T value) {
    return data.remove(value);
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public int size() {
    return data.size();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * Since the internal JDK node structure is not exposed, this implementation
   * reports the number of levels needed by a complete tree with the same number
   * of nodes. The result is therefore a balanced-tree estimate, not a direct
   * inspection of private JDK state.
   * </p>
   *
   * @implNote Time complexity is {@code O(log n)}.
   */
  @Override
  public int height() {
    return TreeHeights.completeTreeHeight(data.size());
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * Copying the ordered set into a list yields ascending output, which matches
   * the meaning of an in-order traversal in a BST.
   * </p>
   *
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public List<T> inOrder() {
    return new ArrayList<>(data);
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public void clear() {
    data.clear();
  }

}
