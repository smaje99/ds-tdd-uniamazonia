package co.edu.udla.ed.impl.linear;

import java.util.ArrayList;
import java.util.List;

import co.edu.udla.ed.api.BinarySearchTree;

/**
 * BST representation backed by a sorted list and linear scans.
 *
 * <p>
 * This class does not maintain an actual linked tree. Instead, it preserves
 * the observable BST rules through a sorted sequence of values. The design is
 * intentionally didactic: students can still validate the API contract while
 * seeing how costs degrade when structure-specific shortcuts are removed.
 * </p>
 *
 * @param <T> the element type
 */
public class LinearBinarySearchTree<T extends Comparable<T>> implements BinarySearchTree<T> {

  private final List<T> data = new ArrayList<>();

  /**
   * {@inheritDoc}
   *
   * <p>
   * The list remains sorted at all times. Duplicate values are ignored to match
   * the repository BST contract.
   * </p>
   *
   * @implNote Time complexity is {@code O(n)} because the insertion point is
   *           found by linear scan and later elements may shift.
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
   * Because this implementation does not store actual tree links, it reports
   * the worst-case BST height for {@code n} sorted insertions: a chain of
   * {@code n} levels.
   * </p>
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public int height() {
    return data.size();
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
