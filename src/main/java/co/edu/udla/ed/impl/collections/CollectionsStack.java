package co.edu.udla.ed.impl.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

import co.edu.udla.ed.api.Stack;

/**
 * Stack adapter backed by {@link ArrayDeque}.
 *
 * <p>
 * The deque stores stack elements so that the logical top is the logical end
 * of the deque. This lets {@code push}, {@code pop}, and {@code peek} map
 * directly to efficient deque operations while preserving the standard
 * last-in, first-out behavior students expect from a stack.
 * </p>
 *
 * @param <T> the element type
 */
public class CollectionsStack<T> implements Stack<T> {

  private final Deque<T> data = new ArrayDeque<>();

  /**
   * {@inheritDoc}
   *
   * @implNote Amortized time complexity is {@code O(1)}.
   */
  @Override
  public void push(T value) {
    data.addLast(value);
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
    return data.removeLast();
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
    return data.getLast();
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
