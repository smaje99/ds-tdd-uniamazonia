package co.edu.udla.ed.contract;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.Stack;

public abstract class AbstractStackContractTest {

  protected abstract Stack<Integer> create();

  @Test
  void starts_empty() {
    var s = create();
    assertThat(s.isEmpty()).isTrue();
    assertThat(s.size()).isZero();
  }

  @Test
  void push_pop_should_be_lifo() {
    var s = create();
    s.push(1);
    s.push(2);
    s.push(3);

    assertThat(s.pop()).isEqualTo(3);
    assertThat(s.pop()).isEqualTo(2);
    assertThat(s.pop()).isEqualTo(1);
    assertThat(s.isEmpty()).isTrue();
  }

  @Test
  void peek_should_not_remove() {
    var s = create();
    s.push(10);
    s.push(20);

    assertThat(s.peek()).isEqualTo(20);
    assertThat(s.size()).isEqualTo(2);
    assertThat(s.pop()).isEqualTo(20);
    assertThat(s.pop()).isEqualTo(10);
  }

  @Test
  void pop_on_empty_should_throw() {
    var s = create();
    assertThatThrownBy(s::pop).isInstanceOf(NoSuchElementException.class);
  }

  @Test
  void peek_on_empty_should_throw() {
    var s = create();
    assertThatThrownBy(s::peek).isInstanceOf(NoSuchElementException.class);
  }

  @Test
  void clear_should_reset() {
    var s = create();
    s.push(1);
    s.push(2);

    s.clear();

    assertThat(s.isEmpty()).isTrue();
    assertThatThrownBy(s::pop).isInstanceOf(NoSuchElementException.class);
  }

}
