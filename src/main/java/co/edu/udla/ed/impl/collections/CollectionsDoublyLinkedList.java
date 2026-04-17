package co.edu.udla.ed.impl.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import co.edu.udla.ed.api.DoublyList;

/**
 * Doubly-list adapter backed directly by {@link LinkedList}.
 *
 * <p>
 * The internal Java collection already stores links in both directions, so it
 * is a natural wrapper for the educational doubly linked-list API. The class
 * preserves the same external rules as the project contract: zero-based
 * indexing, insertion and removal at both ends, and {@code equals}-based
 * membership checks.
 * </p>
 *
 * @param <T> the element type
 */
public class CollectionsDoublyLinkedList<T> implements DoublyList<T> {

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
   * @implNote Time complexity is {@code O(n)} because the linked structure must
   *           traverse to the requested position.
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
   * Returns an iterator that traverses the list from head to tail.
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
