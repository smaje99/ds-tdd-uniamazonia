package co.edu.udla.ed.api;

/**
 * Interface representing a stack data structure. A stack is a collection of
 * elements that follows the Last In, First Out (LIFO) principle.
 *
 * @param <T> the type of elements in the stack
 */
public interface Stack<T> {

  void push(T value);

  T pop();

  T peek();

  int size();

  /**
   * Returns true if the stack is empty, false otherwise.
   * This operation has complexity O(1) since it only checks the size of the stack
   * without modifying it.
   *
   * @return true if the stack is empty, false otherwise
   */
  default boolean isEmpty() {
    return size() == 0;
  }

  void clear();

}
