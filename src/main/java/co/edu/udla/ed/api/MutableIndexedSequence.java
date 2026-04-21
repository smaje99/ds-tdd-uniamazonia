package co.edu.udla.ed.api;

/**
 * Low-level mutable indexed sequence used by sorting algorithms.
 *
 * @param <T> the element type
 */
public interface MutableIndexedSequence<T> {

  int size();

  T get(int index);

  void set(int index, T element);

}
