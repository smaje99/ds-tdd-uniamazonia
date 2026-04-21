package co.edu.udla.ed.scratch;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.common.JavaSortingAdapters;
import co.edu.udla.ed.impl.scratch.sorting.CountingSort;
import co.edu.udla.ed.impl.scratch.sorting.MergeSort;
import co.edu.udla.ed.impl.scratch.sorting.RadixSort;

public class JavaSortingAdaptersTest {

  @Test
  void should_sort_array_list_without_mutating_original() {
    ArrayList<Integer> values = new ArrayList<>(java.util.List.of(4, 1, 3, 2));

    ArrayList<Integer> sorted = JavaSortingAdapters.sorted(values, new MergeSort<>());

    assertThat(sorted).containsExactly(1, 2, 3, 4);
    assertThat(values).containsExactly(4, 1, 3, 2);
  }

  @Test
  void should_sort_linked_list_without_mutating_original() {
    LinkedList<Integer> values = new LinkedList<>(java.util.List.of(4, 1, 3, 2));

    LinkedList<Integer> sorted = JavaSortingAdapters.sorted(values, new MergeSort<>());

    assertThat(sorted).containsExactly(1, 2, 3, 4);
    assertThat(values).containsExactly(4, 1, 3, 2);
  }

  @Test
  void should_sort_array_list_with_counting_and_radix_sort() {
    ArrayList<Integer> values = new ArrayList<>(java.util.List.of(170, 45, 75, 90, 802, 24, 2, 66));

    assertThat(JavaSortingAdapters.sorted(values, new CountingSort()))
        .containsExactly(2, 24, 45, 66, 75, 90, 170, 802);
    assertThat(JavaSortingAdapters.sorted(values, new RadixSort()))
        .containsExactly(2, 24, 45, 66, 75, 90, 170, 802);
  }

  @Test
  void integer_only_sorts_should_reject_custom_comparator_in_jdk_adapters() {
    ArrayList<Integer> values = new ArrayList<>(java.util.List.of(3, 1, 2));

    assertThatThrownBy(() -> JavaSortingAdapters.sorted(values, new CountingSort(), java.util.Comparator.reverseOrder()))
        .isInstanceOf(UnsupportedOperationException.class);
  }

}
