package co.edu.udla.ed.impl.linear;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import co.edu.udla.ed.api.Stack;

/**
 * Stack implementation backed by {@link LinkedList}.
 *
 * <p>
 * The top of the stack is stored at the front of the linked list so that push,
 * pop, and peek are direct end operations. This keeps the implementation
 * iterative, readable, and faithful to standard last-in, first-out semantics.
 * </p>
 *
 * @param <T> the element type
 */
public class LinearStack<T> implements Stack<T> {

  private final LinkedList<T> data = new LinkedList<>();

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public void push(T value) {
    data.addFirst(value);
  }

  /**
   * {@inheritDoc}
   *
   * @throws NoSuchElementException if the stack is empty
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public T pop() {
    if (data.isEmpty()) {
      throw new NoSuchElementException("Stack is empty.");
    }
    return data.removeFirst();
  }

  /**
   * {@inheritDoc}
   *
   * @throws NoSuchElementException if the stack is empty
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public T peek() {
    if (data.isEmpty()) {
      throw new NoSuchElementException("Stack is empty.");
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
   * @implNote Time complexity is {@code O(n)} because stored references are
   *           discarded.
   */
  @Override
  public void clear() {
    data.clear();
  }

}
