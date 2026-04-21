package co.edu.udla.ed.impl.scratch.sorting;

import co.edu.udla.ed.api.MutableIndexedSequence;

public final class JavaListSequenceAdapter<T> implements MutableIndexedSequence<T> {

  private final java.util.List<T> list;

  public JavaListSequenceAdapter(java.util.List<T> list) {
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
