package co.edu.udla.ed.contract;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.SimpleList;

public abstract class AbstractSimpleListContractTest {

  protected abstract SimpleList<Integer> createList();

  @Test
  void starts_empty() {
    var list = createList();

    assertThat(list.size()).isZero();
    assertThat(list.isEmpty()).isTrue();
  }

  @Test
  void addLast_then_get_should_match_order() {
    var list = createList();

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
    var list = createList();

    list.addFirst(10);
    list.addFirst(20);
    list.addFirst(30);

    assertThat(list.size()).isEqualTo(3);
    assertThat(list.get(0)).isEqualTo(30);
    assertThat(list.get(1)).isEqualTo(20);
    assertThat(list.get(2)).isEqualTo(10);
  }

  @Test
  void removeFirst_should_follow_fifo_from_front() {
    var list = createList();

    list.addLast(10);
    list.addLast(20);
    list.addLast(30);

    assertThat(list.removeFirst()).isEqualTo(10);
    assertThat(list.removeFirst()).isEqualTo(20);
    assertThat(list.removeFirst()).isEqualTo(30);
    assertThat(list.isEmpty()).isTrue();
  }

  @Test
  void removeLast_should_follow_lifo_from_back() {
    var list = createList();

    list.addLast(10);
    list.addLast(20);
    list.addLast(30);

    assertThat(list.removeLast()).isEqualTo(30);
    assertThat(list.removeLast()).isEqualTo(20);
    assertThat(list.removeLast()).isEqualTo(10);
    assertThat(list.isEmpty()).isTrue();
  }

  @Test
  void remove_on_empty_should_throw() {
    var list = createList();

    assertThatThrownBy(list::removeFirst).isInstanceOf(NoSuchElementException.class);
    assertThatThrownBy(list::removeLast).isInstanceOf(NoSuchElementException.class);
  }

  @Test
  void get_out_of_bounds_should_throw() {
    var list = createList();

    list.addLast(10);

    assertThatThrownBy(() -> list.get(-1)).isInstanceOf(IndexOutOfBoundsException.class);
    assertThatThrownBy(() -> list.get(1)).isInstanceOf(IndexOutOfBoundsException.class);
  }

  @Test
  void clear_should_reset() {
    var list = createList();

    list.addLast(10);
    list.addLast(20);
    list.addLast(30);

    list.clear();

    assertThat(list.size()).isZero();
    assertThat(list.isEmpty()).isTrue();
    assertThatThrownBy(list::removeFirst).isInstanceOf(NoSuchElementException.class);
  }

  @Test
  void iterator_should_traverse_in_order() {
    var list = createList();

    list.addLast(10);
    list.addLast(20);
    list.addLast(30);

    assertThat(list).containsExactly(10, 20, 30);
  }
}
