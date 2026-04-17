package co.edu.udla.ed.impl.linear;

import java.util.ArrayList;
import java.util.List;

import co.edu.udla.ed.api.AVLTree;
import co.edu.udla.ed.common.TreeHeights;

/**
 * AVL representation backed by a sorted list and iterative logic.
 *
 * <p>
 * Like the linear BST wrapper, this class does not store explicit left and
 * right child links. It preserves the observable AVL behavior through sorted
 * values plus a balanced-tree height estimate, which makes it useful for
 * comparing API semantics against a much simpler internal representation.
 * </p>
 *
 * @param <T> the element type
 */
public class LinearAVLTree<T extends Comparable<T>> implements AVLTree<T> {

  private final List<T> data = new ArrayList<>();

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public void insert(T value) {
    for (int i = 0; i < data.size(); i++) {
      int comparison = value.compareTo(data.get(i));
      if (comparison == 0) {
        return;
      }
      if (comparison < 0) {
        data.add(i, value);
        return;
      }
    }
    data.add(value);
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public boolean contains(T value) {
    for (T current : data) {
      if (current.compareTo(value) == 0) {
        return true;
      }
    }
    return false;
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public boolean remove(T value) {
    for (int i = 0; i < data.size(); i++) {
      if (data.get(i).compareTo(value) == 0) {
        data.remove(i);
        return true;
      }
    }
    return false;
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
   * The method reports the height of a balanced complete-tree shape with the
   * same number of values. This matches the learning goal of the AVL contract
   * even though the internal representation is not an actual linked AVL tree.
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
