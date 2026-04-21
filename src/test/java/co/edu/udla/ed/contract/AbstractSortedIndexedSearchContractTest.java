package co.edu.udla.ed.contract;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.IndexedSequence;
import co.edu.udla.ed.api.LinearSearchResult;

public abstract class AbstractSortedIndexedSearchContractTest {

  protected abstract LinearSearchResult<Integer> search(IndexedSequence<Integer> values, Integer target);

  @Test
  void should_find_existing_value() {
    TestSequence<Integer> values = new TestSequence<>(2, 4, 6, 8, 10);
    assertThat(search(values, 8)).isEqualTo(LinearSearchResult.found(3, 8));
  }

  @Test
  void should_report_missing_value() {
    TestSequence<Integer> values = new TestSequence<>(2, 4, 6, 8, 10);
    assertThat(search(values, 7)).isEqualTo(LinearSearchResult.notFound());
  }

  @Test
  void should_find_first_extreme() {
    TestSequence<Integer> values = new TestSequence<>(2, 4, 6, 8, 10);
    assertThat(search(values, 2)).isEqualTo(LinearSearchResult.found(0, 2));
  }

  @Test
  void should_find_last_extreme() {
    TestSequence<Integer> values = new TestSequence<>(2, 4, 6, 8, 10);
    assertThat(search(values, 10)).isEqualTo(LinearSearchResult.found(4, 10));
  }

  protected static final class TestSequence<T> implements IndexedSequence<T> {
    private final java.util.List<T> values = new java.util.ArrayList<>();

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
  }

}
