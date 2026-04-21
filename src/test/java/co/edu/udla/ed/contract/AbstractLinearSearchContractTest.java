package co.edu.udla.ed.contract;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.IndexedSequence;
import co.edu.udla.ed.api.LinearSearchResult;

public abstract class AbstractLinearSearchContractTest {

  protected abstract LinearSearchResult<String> search(IndexedSequence<String> values, String target);

  @Test
  void should_find_existing_value() {
    TestSequence<String> values = new TestSequence<>("red", "blue", "green");
    assertThat(search(values, "blue")).isEqualTo(LinearSearchResult.found(1, "blue"));
  }

  @Test
  void should_report_missing_value() {
    TestSequence<String> values = new TestSequence<>("red", "blue", "green");
    assertThat(search(values, "black")).isEqualTo(LinearSearchResult.notFound());
  }

  @Test
  void should_find_first_duplicate() {
    TestSequence<String> values = new TestSequence<>("red", "blue", "green", "blue");
    assertThat(search(values, "blue")).isEqualTo(LinearSearchResult.found(1, "blue"));
  }

  @Test
  void should_handle_empty_sequence() {
    TestSequence<String> values = new TestSequence<>();
    assertThat(search(values, "blue")).isEqualTo(LinearSearchResult.notFound());
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
