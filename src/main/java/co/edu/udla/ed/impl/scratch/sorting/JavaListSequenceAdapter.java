package co.edu.udla.ed.impl.scratch.sorting;

import co.edu.udla.ed.api.MutableIndexedSequence;

/**
 * Adapter that exposes a JDK {@link java.util.List} as a mutable indexed
 * sequence for repository sorting and searching algorithms.
 *
 * <p>
 * The adapter does not copy data. Calls to {@code set} update the wrapped list
 * directly, so utility methods that promise non-mutating behavior must create a
 * defensive copy before wrapping the JDK collection. Access cost follows the
 * wrapped list implementation: {@code ArrayList} access is constant time, while
 * {@code LinkedList} indexed access is linear.
 * </p>
 *
 * @param <T> element type
 */
public final class JavaListSequenceAdapter<T> implements MutableIndexedSequence<T> {

  private final java.util.List<T> list;

  /**
   * Wraps a JDK list without copying it.
   *
   * @param list list that will be read and mutated through this adapter
   */
  public JavaListSequenceAdapter(java.util.List<T> list) {
    this.list = list;
  }

  /** {@inheritDoc} */
  @Override
  public int size() {
    return list.size();
  }

  /** {@inheritDoc} */
  @Override
  public T get(int index) {
    return list.get(index);
  }

  /** {@inheritDoc} */
  @Override
  public void set(int index, T element) {
    list.set(index, element);
  }

}
