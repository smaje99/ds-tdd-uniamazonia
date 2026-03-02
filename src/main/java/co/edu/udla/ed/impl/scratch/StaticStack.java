package co.edu.udla.ed.impl.scratch;

import java.util.NoSuchElementException;

import co.edu.udla.ed.api.Stack;

/**
 * StaticStack is a stack implementation that uses a fixed-size array to store its
 * elements. It provides methods to push, pop, peek, check the size, and clear
 * the stack. The stack follows the Last-In-First-Out (LIFO) principle, meaning
 * that the last element pushed onto the stack will be the first one to be popped
 * off. This implementation allows for dynamic resizing of the internal array as
 * elements are added or removed, ensuring efficient memory usage while maintaining
 * fast access times.
 *
 * @param <T> the type of elements stored in the stack
 */
public class StaticStack<T> implements Stack<T> {

  private Object[] data;
  private int size;

  public StaticStack() {
    this(10); // Default initial capacity
  }

  public StaticStack(int initialCapacity) {
    if (initialCapacity <= 0) {
      throw new IllegalArgumentException("Initial capacity must be greater than 0.");
    }
    this.data = new Object[initialCapacity];
    this.size = 0;
  }

  /**
   * Adds an element to the top of the stack. If the internal array is full, it is
   * resized to accommodate more elements. This operation has an amortized time
   * complexity of O(1) due to the resizing strategy, which doubles the capacity
   * when needed, ensuring that most push operations run in constant time.
   *
   * @param value the element to be added to the stack
   */
  @Override
  public void push(T value) {
    ensureCapacity(size + 1);
    data[size++] = value;
  }

  /**
   * Removes and returns the element at the top of the stack. If the stack is
   * empty, a NoSuchElementException is thrown. This operation has a time
   * complexity of O(1) since it simply decrements the size and returns the
   * top element without needing to shift any elements.
   *
   * @return the element at the top of the stack
   * @throws NoSuchElementException if the stack is empty
   */
  @Override
  public T pop() {
    if (size == 0) {
      throw new NoSuchElementException("Stack is empty.");
    }
    int idx = --size;

    @SuppressWarnings("unchecked")
    T value = (T) data[idx];

    data[idx] = null; // Help GC
    return value;
  }

  /**
   * Returns the element at the top of the stack without removing it. If the stack
   * is empty, a NoSuchElementException is thrown. This operation has a time
   * complexity of O(1) since it simply returns the top element without modifying
   * the stack.
   *
   * @return the element at the top of the stack
   * @throws NoSuchElementException if the stack is empty
   */
  @Override
  public T peek() {
    if (size == 0) {
      throw new NoSuchElementException("Stack is empty.");
    }
    @SuppressWarnings("unchecked")
    T value = (T) data[size - 1];
    return value;
  }

  /**
   * Returns the number of elements currently in the stack. This operation has a
   * time complexity of O(1) since it simply returns the value of the size
   * variable without needing to iterate through the stack or perform any
   * calculations.
   *
   * @return the number of elements in the stack
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Removes all elements from the stack, effectively resetting it to an empty
   * state. This operation has a time complexity of O(n) where n is the number of
   * elements in the stack, since it iterates through the internal array to set
   * each element to null, allowing for garbage collection. After clearing, the
   * size is reset to 0.
   */
  @Override
  public void clear() {
    for (int i = 0; i < size; i++) {
      data[i] = null;
    }
    size = 0;
  }

  /**
   * Ensures that the internal array has enough capacity to hold the specified
   * number of elements. If the current capacity is insufficient, the array is
   * resized to accommodate the needed capacity.
   *
   * @param needed the number of elements that need to be accommodated
   */
  private void ensureCapacity(int needed) {
    if (needed <= data.length)
      return;
    int newCap = Math.max(needed, Math.max(1, data.length * 2));
    Object[] newData = new Object[newCap];
    System.arraycopy(data, 0, newData, 0, size);
    data = newData;
  }

}
