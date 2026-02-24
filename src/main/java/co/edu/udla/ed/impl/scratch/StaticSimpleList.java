package co.edu.udla.ed.impl.scratch;

import java.util.Iterator;
import java.util.NoSuchElementException;

import co.edu.udla.ed.api.SimpleList;

/**
 * A simple implementation of a list using a static array as the underlying
 * data structure. This implementation supports basic list operations such as
 * adding, removing, and retrieving elements. The list automatically resizes
 * when necessary to accommodate more elements.
 *
 * @param <T> the type of elements in this list
 */
public class StaticSimpleList<T> implements SimpleList<T> {

  private Object[] data;
  private int size;

  public StaticSimpleList() {
    this(10); // Default initial capacity
  }

  public StaticSimpleList(int initialCapacity) {
    if (initialCapacity <= 0) {
      throw new IllegalArgumentException("Initial capacity must be greater than zero.");
    }

    this.data = new Object[initialCapacity];
    this.size = 0;
  }

  /**
   * Adds an element to the front of the list.
   *
   * @param element the element to add
   */
  @Override
  public void addFirst(T element) {
    ensureCapacity(size + 1);
    // shift elements to the right
    for (int i = size; i > 0; i--) {
      data[i] = data[i - 1];
    }
    data[0] = element;
    size++;
  }

  /**
   * Adds an element to the end of the list.
   *
   * @param element the element to add
   */
  @Override
  public void addLast(T element) {
    ensureCapacity(size + 1);
    data[size] = element;
    size++;
  }

  /**
   * Removes and returns the first element of the list.
   *
   * @return the removed element
   * @throws NoSuchElementException if the list is empty
   */
  @Override
  public T removeFirst() {
    if (size == 0) {
      throw new NoSuchElementException("List is empty.");
    }
    @SuppressWarnings("unchecked")
    T removed = (T) data[0];
    // shift elements to the left
    for (int i = 0; i < size - 1; i++) {
      data[i] = data[i + 1];
    }
    data[size - 1] = null; // Help GC
    size--;
    return removed;
  }

  /**
   * Removes and returns the last element of the list.
   *
   * @return the removed element
   * @throws NoSuchElementException if the list is empty
   */
  @Override
  public T removeLast() {
    if (size == 0) {
      throw new NoSuchElementException("List is empty.");
    }

    int lastIndex = size - 1;

    @SuppressWarnings("unchecked")
    T removed = (T) data[lastIndex];
    data[lastIndex] = null; // Help GC
    size--;
    return removed;
  }

  @Override
  public T get(int index) {
    checkIndex(index);
    @SuppressWarnings("unchecked")
    T element = (T) data[index];
    return element;
  }

  /**
   * Checks if the list contains the specified element.
   *
   * @param element the element to check for
   * @return true if the element is found, false otherwise
   */
  @Override
  public boolean contains(T element) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(element)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns the number of elements in the list.
   *
   * @return the size of the list
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Removes all elements from the list, resetting it to an empty state.
   */
  @Override
  public void clear() {
    for (int i = 0; i < size; i++) {
      data[i] = null; // Help GC
    }
    size = 0;
  }

  /**
   * Returns an iterator over the elements in this list in proper sequence.
   *
   * @return an iterator over the elements in this list
   */
  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private int currentIndex = 0;

      @Override
      public boolean hasNext() {
        return currentIndex < size;
      }

      @Override
      public T next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        @SuppressWarnings("unchecked")
        T element = (T) data[currentIndex];
        currentIndex++;
        return element;
      }
    };
  }

  /**
   * Ensures that the internal array has enough capacity to hold the specified
   * number of elements.
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

  /**
   * Checks if the given index is within the bounds of the list.
   *
   * @param index the index to check
   * @throws IndexOutOfBoundsException if the index is out of bounds
   */
  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("index=" + index + ", size=" + size);
    }
  }
}
