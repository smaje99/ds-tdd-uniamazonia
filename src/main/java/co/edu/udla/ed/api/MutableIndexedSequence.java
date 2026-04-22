package co.edu.udla.ed.api;

/**
 * Low-level mutable indexed sequence used by sorting algorithms.
 *
 * @param <T> the element type
 */
public interface MutableIndexedSequence<T> extends IndexedSequence<T> {

  /**
   * Replaces the value at a zero-based index.
   *
   * @param index index to update
   * @param element replacement value
   * @throws IndexOutOfBoundsException if {@code index < 0} or
   *         {@code index >= size()}
   */
  void set(int index, T element);

}
