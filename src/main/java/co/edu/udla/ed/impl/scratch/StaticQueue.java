package co.edu.udla.ed.impl.scratch;

import java.util.NoSuchElementException;

import co.edu.udla.ed.api.Queue;

/**
 * StaticQueue is a queue implementation that uses a fixed-size array to store
 * elements. It maintains two indices, head and tail, to track the front and rear
 * of the queue, respectively. The queue supports dynamic resizing when the
 * capacity is exceeded, ensuring that it can grow as needed while maintaining
 * efficient enqueue and dequeue operations.
 *
 * @param <T> the type of elements held in this queue
 */
public class StaticQueue<T> implements Queue<T> {

  private Object[] data;
  private int head; // índice del frente
  private int tail; // índice donde entra el próximo
  private int size;

  public StaticQueue() {
    this(10); // capacidad inicial por defecto
  }

  public StaticQueue(int initialCapacity) {
    if (initialCapacity < 0) {
      throw new IllegalArgumentException("Initial capacity must be non-negative.");
    }

    this.data = new Object[Math.max(initialCapacity, 1)];
    this.head = 0;
    this.tail = 0;
    this.size = 0;
  }

  /**
   * Adds the specified value to the rear of the queue. If the internal array is
   * full, it will be resized to accommodate additional elements. The method
   * ensures that the new value is added at the correct position and updates the
   * tail index and size accordingly. This operation has an amortized time
   * complexity of O(1) due to the resizing strategy, which minimizes the number
   * of times the array needs to be resized as the queue grows.
   *
   * @param value the value to be added to the rear of the queue
   */
  @Override
  public void enqueue(T value) {
    ensureCapacity(size + 1);
    data[tail] = value;
    tail = (tail + 1) % data.length;
    size++;
  }

  /**
   * Removes and returns the value at the front of the queue. If the queue is
   * empty, it throws a NoSuchElementException. The method retrieves the value at
   * the head index, sets that position to null to help with garbage collection,
   * and then updates the head index and size accordingly. This operation has a
   * time complexity of O(1).
   *
   * @return the value at the front of the queue
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public T dequeue() {
    if (size == 0)
      throw new NoSuchElementException("Queue is empty.");

    @SuppressWarnings("unchecked")
    T value = (T) data[head];

    data[head] = null;
    head = (head + 1) % data.length;
    size--;
    return value;
  }

  /**
   * Returns the value at the front of the queue without removing it. If the queue
   * is empty, it throws a NoSuchElementException. The method retrieves the value
   * at the head index and returns it without modifying the queue's state. This
   * operation has a time complexity of O(1).
   *
   * @return the value at the front of the queue
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public T peek() {
    if (size == 0)
      throw new NoSuchElementException("Queue is empty.");

    @SuppressWarnings("unchecked")
    T value = (T) data[head];
    return value;
  }

  /**
   * Returns the number of elements currently in the queue. This method simply
   * returns the value of the size variable, which is updated during enqueue and
   * dequeue operations. The time complexity of this operation is O(1).
   *
   * @return the number of elements in the queue
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Clears the queue by resetting the head and tail indices and setting all
   * elements in the internal array to null to allow for garbage collection. The
   * size is also reset to zero. This operation has a time complexity of O(n),
   * where n is the current size of the queue, due to the need to iterate through
   * the elements to nullify them.
   */
  @Override
  public void clear() {
    // limpiar referencias para GC
    for (int i = 0; i < size; i++) {
      int idx = (head + i) % data.length;
      data[idx] = null;
    }
    head = tail = 0;
    size = 0;
  }

  /**
   * Ensures that the internal array has enough capacity to hold the specified
   * number of elements. If not, it resizes the array to accommodate the new
   * capacity. The new capacity is determined by taking the maximum of the needed
   * capacity and twice the current array length, which helps to minimize future
   * resizing operations.
   *
   * @param needed the number of elements that need to be accommodated in the
   *               queue
   */
  private void ensureCapacity(int needed) {
    if (needed <= data.length)
      return;

    int newCap = Math.max(needed, data.length * 2);
    Object[] newData = new Object[newCap];

    // copiar en orden lógico (desde head)
    for (int i = 0; i < size; i++) {
      newData[i] = data[(head + i) % data.length];
    }

    data = newData;
    head = 0;
    tail = size;
  }

}
