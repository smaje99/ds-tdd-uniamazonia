package co.edu.udla.ed.contract;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.CircularList;

public abstract class AbstractCircularListContractTest {

  protected abstract CircularList<Integer> create();

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

    assertThat(list).containsExactly(10, 20, 30);
    assertThat(list.get(0)).isEqualTo(10);
    assertThat(list.get(2)).isEqualTo(30);
  }

  @Test
  void addFirst_should_prepend() {
    var list = create();
    list.addFirst(10);
    list.addFirst(20);
    list.addFirst(30);

    assertThat(list).containsExactly(30, 20, 10);
  }

  @Test
  void removeFirst_should_work() {
    var list = create();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);

    assertThat(list.removeFirst()).isEqualTo(1);
    assertThat(list).containsExactly(2, 3);
    assertThat(list.size()).isEqualTo(2);
  }

  @Test
  void removeLast_should_work() {
    var list = create();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);

    assertThat(list.removeLast()).isEqualTo(3);
    assertThat(list).containsExactly(1, 2);
    assertThat(list.size()).isEqualTo(2);
  }

  @Test
  void remove_until_empty_should_keep_consistency() {
    var list = create();
    list.addLast(1);
    list.addLast(2);

    assertThat(list.removeLast()).isEqualTo(2);
    assertThat(list.removeLast()).isEqualTo(1);

    assertThat(list.isEmpty()).isTrue();
    assertThatThrownBy(list::removeFirst).isInstanceOf(NoSuchElementException.class);
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
  }

}
