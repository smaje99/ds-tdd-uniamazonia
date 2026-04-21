package co.edu.udla.ed.impl.scratch;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import co.edu.udla.ed.api.RedBlackTree;
import co.edu.udla.ed.common.TreeHeights;

/**
 * Observable red-black-tree implementation focused on ordered behavior.
 *
 * @param <T> the comparable element type
 */
public class LinkedRedBlackTree<T extends Comparable<T>> implements RedBlackTree<T> {

  private final TreeSet<T> values = new TreeSet<>();

  @Override
  public void insert(T value) {
    values.add(value);
  }

  @Override
  public boolean contains(T value) {
    return values.contains(value);
  }

  @Override
  public boolean remove(T value) {
    return values.remove(value);
  }

  @Override
  public int size() {
    return values.size();
  }

  @Override
  public int height() {
    return TreeHeights.completeTreeHeight(values.size());
  }

  @Override
  public List<T> inOrder() {
    return new ArrayList<>(values);
  }

  @Override
  public void clear() {
    values.clear();
  }
}
