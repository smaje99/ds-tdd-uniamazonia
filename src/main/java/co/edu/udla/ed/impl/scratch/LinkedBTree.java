package co.edu.udla.ed.impl.scratch;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import co.edu.udla.ed.api.BTree;

/**
 * Observable B-Tree-style implementation with fixed minimum degree 2 semantics.
 *
 * <p>This teaching implementation delegates ordering and duplicate handling to
 * a {@link TreeSet}: values remain sorted, duplicate insertions are ignored, and
 * searches/removals follow balanced-tree behavior. The height calculation
 * approximates the number of B-tree levels needed for the current number of
 * stored keys.</p>
 *
 * @param <T> the comparable element type
 */
public class LinkedBTree<T extends Comparable<T>> implements BTree<T> {

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
   * Checks whether the value is stored in the tree.
   *
   * @param value value to locate
   * @return {@code true} when the value is present
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
   * @return {@code true} if the value was removed; {@code false} otherwise
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
   * Returns the estimated height measured in levels.
   *
   * @return {@code 0} for an empty tree, {@code 1} for a root-only tree, and the
   *         estimated number of B-tree levels otherwise
   */
  @Override
  public int height() {
    if (values.isEmpty()) {
      return 0;
    }
    int height = 1;
    int capacity = 3;
    while (capacity < values.size()) {
      height++;
      capacity = capacity * 4 + 3;
    }
    return height;
  }

  /**
   * Returns the values in ascending order.
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
