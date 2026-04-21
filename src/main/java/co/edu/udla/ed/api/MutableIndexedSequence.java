package co.edu.udla.ed.api;

/**
 * Low-level mutable indexed sequence used by sorting algorithms.
 *
 * @param <T> the element type
 */
public interface MutableIndexedSequence<T> extends IndexedSequence<T> {

  void set(int index, T element);

}
