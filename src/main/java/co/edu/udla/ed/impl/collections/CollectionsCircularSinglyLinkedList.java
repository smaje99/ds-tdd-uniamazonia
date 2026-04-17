package co.edu.udla.ed.impl.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import co.edu.udla.ed.api.CircularList;

/**
 * Circular-list adapter backed by {@link LinkedList}.
 *
 * <p>
 * The internal representation is not literally circular. Instead, this class
 * exposes the same public behavior as the circular-list API while relying on a
 * standard linked list for storage. It is therefore best understood as an
 * adapter that matches the contract, not as a demonstration of circular links.
 * </p>
 *
 * @param <T> the element type
 */
public class CollectionsCircularSinglyLinkedList<T> implements CircularList<T> {

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
    return data.get(index);
  }

  /**
   * {@inheritDoc}
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
