package co.edu.udla.ed.impl.scratch;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import co.edu.udla.ed.api.RedBlackTree;
import co.edu.udla.ed.common.TreeHeights;

/**
 * Observable red-black-tree implementation focused on ordered behavior.
 *
 * <p>This class uses a {@link TreeSet} to provide the sorted-set behavior that
 * students expect from a red-black tree: logarithmic insertion, lookup, and
 * removal, ignored duplicates, and ascending traversal. The height method
 * exposes an idealized complete-tree height for the current size rather than
 * the internal JDK tree height.</p>
 *
 * @param <T> the comparable element type
 */
public class LinkedRedBlackTree<T extends Comparable<T>> implements RedBlackTree<T> {

  private final TreeSet<T> values = new TreeSet<>();

  /**
   * Inserts a value when it is not already present.
   *
   * @param value value to insert
   * @implNote Time complexity is {@code O(log n)}.
   */
  @Override
  public void insert(T value) {
    values.add(value);
  }

  /**
   * Checks whether a value is present.
   *
   * @param value value to locate
   * @return {@code true} when the value exists in the tree
   * @implNote Time complexity is {@code O(log n)}.
   */
  @Override
  public boolean contains(T value) {
    return values.contains(value);
  }

  /**
   * Removes a value if it exists.
   *
   * @param value value to remove
   * @return {@code true} if the tree changed
   * @implNote Time complexity is {@code O(log n)}.
   */
  @Override
  public boolean remove(T value) {
    return values.remove(value);
  }

  /**
   * Returns the number of stored values.
   *
   * @return tree size
   */
  @Override
  public int size() {
    return values.size();
  }

  /**
   * Returns the idealized height measured in levels.
   *
   * @return {@code 0} for an empty tree or the complete-tree level count for
   *         the current size
   */
  @Override
  public int height() {
    return TreeHeights.completeTreeHeight(values.size());
  }

  /**
   * Returns all values in ascending order.
   *
   * @return sorted traversal result
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public List<T> inOrder() {
    return new ArrayList<>(values);
  }

  /**
   * Removes all stored values.
   */
  @Override
  public void clear() {
    values.clear();
  }
}
