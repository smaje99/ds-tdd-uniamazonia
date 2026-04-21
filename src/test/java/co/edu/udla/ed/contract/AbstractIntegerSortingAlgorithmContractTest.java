package co.edu.udla.ed.contract;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.SortingAlgorithm;

public abstract class AbstractIntegerSortingAlgorithmContractTest {

  protected abstract SortingAlgorithm<Integer> createAlgorithm();

  @Test
  void should_sort_non_negative_values() {
    var values = new AbstractSortingAlgorithmContractTest.TestSequence<>(170, 45, 75, 90, 802, 24, 2, 66);
    createAlgorithm().sort(values);
    assertThat(values.get(0)).isEqualTo(2);
    assertThat(values.get(7)).isEqualTo(802);
  }

  @Test
  void should_sort_with_duplicates_and_zero() {
    var values = new AbstractSortingAlgorithmContractTest.TestSequence<>(0, 5, 3, 5, 0, 2);
    createAlgorithm().sort(values);
    assertThat(values.get(0)).isZero();
    assertThat(values.get(1)).isZero();
    assertThat(values.get(5)).isEqualTo(5);
  }

  @Test
  void should_reject_negative_values() {
    var values = new AbstractSortingAlgorithmContractTest.TestSequence<>(3, -1, 2);
    assertThatThrownBy(() -> createAlgorithm().sort(values))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_reject_custom_comparators() {
    var values = new AbstractSortingAlgorithmContractTest.TestSequence<>(3, 1, 2);
    assertThatThrownBy(() -> createAlgorithm().sort(values, java.util.Comparator.reverseOrder()))
        .isInstanceOf(UnsupportedOperationException.class);
  }

}
