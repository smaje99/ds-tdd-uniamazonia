package co.edu.udla.ed.impl.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import co.edu.udla.ed.api.SimpleList;

/**
 * Simple-list adapter backed directly by {@link ArrayList}.
 *
 * <p>
 * This implementation is useful for comparing the project API against a
 * standard resizable array. It keeps the same observable list behavior as the
 * scratch versions, but delegates storage growth and indexed access to the Java
 * Collections Framework.
 * </p>
 *
 * @param <T> the element type
 */
public class CollectionsSimpleList<T> implements SimpleList<T> {

  private final java.util.List<T> data = new ArrayList<>();

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(n)} because all existing elements
   *           must shift one position to the right.
   */
  @Override
  public void addFirst(T element) {
    data.add(0, element);
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Amortized time complexity is {@code O(1)} for the underlying
   *           resizable array.
   */
  @Override
  public void addLast(T element) {
    data.add(element);
  }

  /**
   * {@inheritDoc}
   *
   * @throws NoSuchElementException if the list is empty
   *
   * @implNote Time complexity is {@code O(n)} because remaining elements shift
   *           left after removal.
   */
  @Override
  public T removeFirst() {
    if (data.isEmpty()) {
      throw new NoSuchElementException("List is empty.");
    }
    return data.remove(0);
  }

  /**
   * {@inheritDoc}
   *
   * @throws NoSuchElementException if the list is empty
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public T removeLast() {
    if (data.isEmpty()) {
      throw new NoSuchElementException("List is empty.");
    }
    return data.remove(data.size() - 1);
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(1)} because {@link ArrayList}
   *           supports direct indexed access.
   */
  @Override
  public T get(int index) {
    return data.get(index);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * Equality is delegated to the underlying list implementation, which compares
   * candidate elements using {@code equals}.
   * </p>
   *
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public boolean contains(T element) {
    return data.contains(element);
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
   * @implNote Time complexity is {@code O(n)} because stored references are
   *           discarded from the backing array.
   */
  @Override
  public void clear() {
    data.clear();
  }

  /**
   * Returns an iterator that traverses the logical list from index {@code 0}
   * to index {@code size() - 1}.
   *
   * @return an iterator in logical list order
   *
   * @implNote Creating the iterator is {@code O(1)}.
   */
  @Override
  public Iterator<T> iterator() {
    return data.iterator();
  }

}
