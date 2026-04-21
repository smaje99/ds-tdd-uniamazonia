package co.edu.udla.ed.api;

/**
 * Read-only indexed sequence used by search algorithms.
 *
 * @param <T> the element type
 */
public interface IndexedSequence<T> {

  int size();

  T get(int index);

}
