package co.edu.udla.ed.impl.scratch.sorting;

import co.edu.udla.ed.api.List;
import co.edu.udla.ed.api.MutableIndexedSequence;

public final class ScratchListSequenceAdapter<T> implements MutableIndexedSequence<T> {

  private final List<T> list;

  public ScratchListSequenceAdapter(List<T> list) {
    this.list = list;
  }

  @Override
  public int size() {
    return list.size();
  }

  @Override
  public T get(int index) {
    return list.get(index);
  }

  @Override
  public void set(int index, T element) {
    list.set(index, element);
  }

}
