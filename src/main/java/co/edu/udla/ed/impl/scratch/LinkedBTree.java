package co.edu.udla.ed.impl.scratch;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import co.edu.udla.ed.api.BTree;

/**
 * Observable B-Tree implementation with fixed minimum degree 2.
 *
 * @param <T> the comparable element type
 */
public class LinkedBTree<T extends Comparable<T>> implements BTree<T> {

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

  @Override
  public List<T> inOrder() {
    return new ArrayList<>(values);
  }

  @Override
  public void clear() {
    values.clear();
  }
}
