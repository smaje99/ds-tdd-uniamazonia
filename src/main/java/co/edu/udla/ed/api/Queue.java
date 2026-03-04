package co.edu.udla.ed.api;

/**
 * A queue is a linear data structure that follows the First In First Out (FIFO)
 * principle. It allows elements to be added at the rear and removed from the
 * front.
 *
 * @param <T> the type of elements held in this queue
 */
public interface Queue<T> {

  void enqueue(T value);

  T dequeue();

  T peek();

  int size();

  /**
   * Returns true if the queue is empty, false otherwise.
   *
   * @return true if the queue is empty, false otherwise
   */
  default boolean isEmpty() {
    return size() == 0;
  }

  void clear();

}
