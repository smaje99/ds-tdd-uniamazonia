package co.edu.udla.ed.impl.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import co.edu.udla.ed.api.AVLTree;
import co.edu.udla.ed.common.TreeHeights;

/**
 * AVL adapter backed by {@link TreeSet}.
 *
 * <p>
 * The wrapper exposes the observable behavior expected from the repository AVL
 * API: sorted in-order traversal, ignored duplicates, and logarithmic-style
 * lookup/update performance. As with the collections BST wrapper, the precise
 * private tree shape of {@link TreeSet} is not visible, so the reported height
 * is a balanced-tree estimate rather than an exact node-by-node measurement.
 * </p>
 *
 * @param <T> the element type
 */
public class CollectionsAVLTree<T extends Comparable<T>> implements AVLTree<T> {

  private final TreeSet<T> data = new TreeSet<>();

  /**
   * {@inheritDoc}
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
   * The height is reported as the number of levels of a complete tree with the
   * same number of nodes, which provides a useful didactic approximation for a
   * balanced structure when internal nodes are not accessible.
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
