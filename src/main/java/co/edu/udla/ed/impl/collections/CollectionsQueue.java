package co.edu.udla.ed.impl.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

import co.edu.udla.ed.api.Queue;

/**
 * Queue adapter backed by {@link ArrayDeque}.
 *
 * <p>
 * The deque stores elements in first-in, first-out order: new elements are
 * appended at the logical rear and removals happen at the logical front.
 * </p>
 *
 * @param <T> the element type
 */
public class CollectionsQueue<T> implements Queue<T> {

  private final Deque<T> data = new ArrayDeque<>();

  /**
   * {@inheritDoc}
   *
   * @implNote Amortized time complexity is {@code O(1)}.
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
   * @implNote Time complexity is {@code O(n)} because all stored references are
   *           discarded.
   */
  @Override
  public void clear() {
    data.clear();
  }

}
