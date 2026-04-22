package co.edu.udla.ed.impl.scratch.sorting;

import co.edu.udla.ed.api.List;
import co.edu.udla.ed.api.MutableIndexedSequence;

/**
 * Adapter that exposes the repository {@link List} abstraction as a mutable
 * indexed sequence.
 *
 * <p>
 * Sorting algorithms use this adapter so they can work with every scratch list
 * implementation through the same minimal operations: {@code size},
 * {@code get}, and {@code set}. The adapter does not copy data; it mutates the
 * wrapped scratch list directly.
 * </p>
 *
 * @param <T> element type
 */
public final class ScratchListSequenceAdapter<T> implements MutableIndexedSequence<T> {

  private final List<T> list;

  /**
   * Wraps a repository list without copying it.
   *
   * @param list list that will be read and mutated through this adapter
   */
  public ScratchListSequenceAdapter(List<T> list) {
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
