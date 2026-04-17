package co.edu.udla.ed.impl.linear;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import co.edu.udla.ed.api.SimpleList;

/**
 * Simple-list implementation that favors explicit iterative logic over random
 * access shortcuts.
 *
 * <p>
 * The list is still backed by {@link LinkedList}, but methods such as
 * {@link #get(int)} and {@link #contains(Object)} are written with visible
 * iterative traversal so students can follow the cost of linear scans more
 * directly.
 * </p>
 *
 * @param <T> the element type
 */
public class LinearSimpleList<T> implements SimpleList<T> {

  private final LinkedList<T> data = new LinkedList<>();

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public void addFirst(T element) {
    data.addFirst(element);
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public void addLast(T element) {
    data.addLast(element);
  }

  /**
   * {@inheritDoc}
   *
   * @throws NoSuchElementException if the list is empty
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public T removeFirst() {
    if (data.isEmpty()) {
      throw new NoSuchElementException("List is empty.");
    }
    return data.removeFirst();
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
    return data.removeLast();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * This implementation walks the list with a {@link ListIterator} instead of
   * relying on direct indexed access so students can see the explicit
   * left-to-right traversal cost.
   * </p>
   *
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public T get(int index) {
    if (index < 0 || index >= data.size()) {
      throw new IndexOutOfBoundsException("index=" + index + ", size=" + data.size());
    }

    ListIterator<T> iterator = data.listIterator();
    for (int i = 0; i < index; i++) {
      iterator.next();
    }
    return iterator.next();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * Equality is checked explicitly with {@code Objects.equals} during the scan.
   * </p>
   *
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public boolean contains(T element) {
    for (T current : data) {
      if (java.util.Objects.equals(current, element)) {
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
   * @implNote Time complexity is {@code O(n)}.
   */
  @Override
  public void clear() {
    data.clear();
  }

  /**
   * Returns an iterator in logical list order.
   *
   * @return an iterator from the first logical element to the last
   *
   * @implNote Creating the iterator is {@code O(1)}.
   */
  @Override
  public Iterator<T> iterator() {
    return data.iterator();
  }

}
