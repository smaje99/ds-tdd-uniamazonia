package co.edu.udla.ed.impl.linear;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import co.edu.udla.ed.api.CircularList;

/**
 * Circular-list implementation that favors iterative traversal.
 *
 * <p>
 * The internal storage is a regular linked list. The class models the circular
 * API contract through its externally visible behavior while keeping access and
 * membership checks written as explicit linear traversals.
 * </p>
 *
 * @param <T> the element type
 */
public class LinearCircularSinglyLinkedList<T> implements CircularList<T> {

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
