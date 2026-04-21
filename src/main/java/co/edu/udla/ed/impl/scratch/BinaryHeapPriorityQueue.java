package co.edu.udla.ed.impl.scratch;

import java.util.Iterator;
import java.util.NoSuchElementException;

import co.edu.udla.ed.api.PriorityQueue;

/**
 * Minimum priority queue backed by a binary heap stored in an array.
 *
 * @param <T> the comparable element type
 */
public class BinaryHeapPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

  private static final int DEFAULT_CAPACITY = 16;

  private Object[] data;
  private int size;

  public BinaryHeapPriorityQueue() {
    this.data = new Object[DEFAULT_CAPACITY];
    this.size = 0;
  }

  @Override
  public void insert(T value) {
    ensureCapacity(size + 1);
    data[size] = value;
    bubbleUp(size);
    size++;
  }

  @Override
  public T removeMin() {
    if (isEmpty()) {
      throw new NoSuchElementException("Priority queue is empty.");
    }
    T min = elementAt(0);
    size--;
    data[0] = data[size];
    data[size] = null;
    if (!isEmpty()) {
      bubbleDown(0);
    }
    return min;
  }

  @Override
  public T peekMin() {
    if (isEmpty()) {
      throw new NoSuchElementException("Priority queue is empty.");
    }
    return elementAt(0);
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void clear() {
    for (int i = 0; i < size; i++) {
      data[i] = null;
    }
    size = 0;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private int index = 0;

      @Override
      public boolean hasNext() {
        return index < size;
      }

      @Override
      public T next() {
        if (!hasNext()) {
          throw new NoSuchElementException("Priority queue iterator exhausted.");
        }
        return elementAt(index++);
      }
    };
  }

  private void ensureCapacity(int neededSize) {
    if (neededSize <= data.length) {
      return;
    }
    Object[] next = new Object[data.length * 2];
    System.arraycopy(data, 0, next, 0, size);
    data = next;
  }

  private void bubbleUp(int index) {
    int current = index;
    while (current > 0) {
      int parent = (current - 1) / 2;
      if (elementAt(current).compareTo(elementAt(parent)) >= 0) {
        return;
      }
      swap(current, parent);
      current = parent;
    }
  }

  private void bubbleDown(int index) {
    int current = index;
    while (true) {
      int left = current * 2 + 1;
      int right = current * 2 + 2;
      if (left >= size) {
        return;
      }
      int smallest = left;
      if (right < size && elementAt(right).compareTo(elementAt(left)) < 0) {
        smallest = right;
      }
      if (elementAt(current).compareTo(elementAt(smallest)) <= 0) {
        return;
      }
      swap(current, smallest);
      current = smallest;
    }
  }

  private void swap(int a, int b) {
    Object tmp = data[a];
    data[a] = data[b];
    data[b] = tmp;
  }

  @SuppressWarnings("unchecked")
  private T elementAt(int index) {
    return (T) data[index];
  }
}
