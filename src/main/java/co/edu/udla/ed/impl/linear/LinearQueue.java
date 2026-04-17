package co.edu.udla.ed.impl.linear;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import co.edu.udla.ed.api.Queue;

/**
 * Queue implementation backed by {@link LinkedList}.
 *
 * <p>
 * New elements are appended at the logical rear and removals happen at the
 * logical front, so the queue preserves first-in, first-out behavior through
 * straightforward end operations on the linked list.
 * </p>
 *
 * @param <T> the element type
 */
public class LinearQueue<T> implements Queue<T> {

  private final LinkedList<T> data = new LinkedList<>();

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public void enqueue(T value) {
    data.addLast(value);
  }

  /**
   * {@inheritDoc}
   *
   * @throws NoSuchElementException if the queue is empty
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public T dequeue() {
    if (data.isEmpty()) {
      throw new NoSuchElementException("Queue is empty.");
    }
    return data.removeFirst();
  }

  /**
   * {@inheritDoc}
   *
   * @throws NoSuchElementException if the queue is empty
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public T peek() {
    if (data.isEmpty()) {
      throw new NoSuchElementException("Queue is empty.");
    }
    return data.getFirst();
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

}
