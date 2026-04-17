package co.edu.udla.ed.impl.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import co.edu.udla.ed.api.CircularList;

/**
 * Circular doubly linked-list adapter backed by {@link LinkedList}.
 *
 * <p>
 * Like the singly circular adapter, this class preserves the public contract
 * of a circular list without exposing actual circular references internally.
 * Its educational role is to show how the project API can be satisfied by a
 * built-in Java structure while keeping the same observable semantics.
 * </p>
 *
 * @param <T> the element type
 */
public class CollectionsCircularDoublyLinkedList<T> implements CircularList<T> {

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
