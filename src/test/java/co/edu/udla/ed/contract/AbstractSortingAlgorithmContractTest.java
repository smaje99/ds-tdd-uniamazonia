package co.edu.udla.ed.contract;

import java.util.ArrayList;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.MutableIndexedSequence;
import co.edu.udla.ed.api.SortingAlgorithm;

public abstract class AbstractSortingAlgorithmContractTest {

  protected abstract SortingAlgorithm<Integer> createAlgorithm();

  @Test
  void should_sort_empty_input() {
    TestSequence<Integer> values = new TestSequence<>();
    createAlgorithm().sort(values);
    assertThat(values.values).isEmpty();
  }

  @Test
  void should_sort_single_element() {
    TestSequence<Integer> values = new TestSequence<>(5);
    createAlgorithm().sort(values);
    assertThat(values.values).containsExactly(5);
  }

  @Test
  void should_keep_sorted_input_sorted() {
    TestSequence<Integer> values = new TestSequence<>(1, 2, 3, 4);
    createAlgorithm().sort(values);
    assertThat(values.values).containsExactly(1, 2, 3, 4);
  }

  @Test
  void should_sort_reverse_input() {
    TestSequence<Integer> values = new TestSequence<>(4, 3, 2, 1);
    createAlgorithm().sort(values);
    assertThat(values.values).containsExactly(1, 2, 3, 4);
  }

  @Test
  void should_sort_duplicates() {
    TestSequence<Integer> values = new TestSequence<>(4, 1, 4, 2, 1);
    createAlgorithm().sort(values);
    assertThat(values.values).containsExactly(1, 1, 2, 4, 4);
  }

  @Test
  void should_support_custom_descending_comparator() {
    TestSequence<Integer> values = new TestSequence<>(4, 1, 3, 2);
    createAlgorithm().sort(values, Comparator.reverseOrder());
    assertThat(values.values).containsExactly(4, 3, 2, 1);
  }

  protected static final class TestSequence<T> implements MutableIndexedSequence<T> {
    private final ArrayList<T> values = new ArrayList<>();

    @SafeVarargs
    TestSequence(T... values) {
      for (T value : values) {
        this.values.add(value);
      }
    }

    @Override
    public int size() {
      return values.size();
    }

    @Override
    public T get(int index) {
      return values.get(index);
    }

    @Override
    public void set(int index, T element) {
      values.set(index, element);
    }
  }

}
