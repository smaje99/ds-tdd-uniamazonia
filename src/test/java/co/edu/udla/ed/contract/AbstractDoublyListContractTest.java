package co.edu.udla.ed.contract;

import java.util.NoSuchElementException;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.DoublyList;
import co.edu.udla.ed.impl.scratch.sorting.BubbleSort;

public abstract class AbstractDoublyListContractTest {

  protected abstract DoublyList<Integer> create();

  @Test
  void starts_empty() {
    var list = create();
    assertThat(list.size()).isZero();
    assertThat(list.isEmpty()).isTrue();
  }

  @Test
  void addLast_then_get_should_match_order() {
    var list = create();
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);

    assertThat(list.size()).isEqualTo(3);
    assertThat(list.get(0)).isEqualTo(10);
    assertThat(list.get(1)).isEqualTo(20);
    assertThat(list.get(2)).isEqualTo(30);
  }

  @Test
  void addFirst_should_prepend() {
    var list = create();
    list.addFirst(10);
    list.addFirst(20);
    list.addFirst(30);

    assertThat(list.get(0)).isEqualTo(30);
    assertThat(list.get(1)).isEqualTo(20);
    assertThat(list.get(2)).isEqualTo(10);
  }

  @Test
  void mixed_operations_should_keep_consistency() {
    var list = create();
    list.addLast(1);   // [1]
    list.addLast(2);   // [1,2]
    list.addFirst(0);  // [0,1,2]
    list.addLast(3);   // [0,1,2,3]

    assertThat(list).containsExactly(0, 1, 2, 3);

    assertThat(list.removeFirst()).isZero(); // [1,2,3]
    assertThat(list.removeLast()).isEqualTo(3);  // [1,2]

    assertThat(list).containsExactly(1, 2);
    assertThat(list.size()).isEqualTo(2);
  }

  @Test
  void remove_on_empty_should_throw() {
    var list = create();
    assertThatThrownBy(list::removeFirst).isInstanceOf(NoSuchElementException.class);
    assertThatThrownBy(list::removeLast).isInstanceOf(NoSuchElementException.class);
  }

  @Test
  void get_out_of_bounds_should_throw() {
    var list = create();
    list.addLast(1);

    assertThatThrownBy(() -> list.get(-1)).isInstanceOf(IndexOutOfBoundsException.class);
    assertThatThrownBy(() -> list.get(1)).isInstanceOf(IndexOutOfBoundsException.class);
  }

  @Test
  void clear_should_reset() {
    var list = create();
    list.addLast(1);
    list.addLast(2);

    list.clear();

    assertThat(list.isEmpty()).isTrue();
    assertThat(list.size()).isZero();
    assertThatThrownBy(list::removeFirst).isInstanceOf(NoSuchElementException.class);
  }

  @Test
  void iterator_should_traverse_in_order() {
    var list = create();
    list.addLast(7);
    list.addLast(8);
    list.addLast(9);

    assertThat(list).containsExactly(7, 8, 9);
  }

  @Test
  void set_should_replace_existing_value() {
    var list = create();
    list.addLast(10);
    list.addLast(20);
    list.set(1, 99);
    assertThat(list).containsExactly(10, 99);
  }

  @Test
  void sorted_should_return_sorted_copy_without_mutating_original() {
    var list = create();
    list.addLast(4);
    list.addLast(1);
    list.addLast(3);
    list.addLast(2);

    DoublyList<Integer> sorted = list.sorted(new BubbleSort<>());

    assertThat(sorted).containsExactly(1, 2, 3, 4);
    assertThat(list).containsExactly(4, 1, 3, 2);
  }

  @Test
  void sorted_should_support_custom_comparator() {
    var list = create();
    list.addLast(4);
    list.addLast(1);
    list.addLast(3);
    list.addLast(2);

    DoublyList<Integer> sorted = list.sorted(new BubbleSort<>(), Comparator.reverseOrder());

    assertThat(sorted).containsExactly(4, 3, 2, 1);
  }

}
