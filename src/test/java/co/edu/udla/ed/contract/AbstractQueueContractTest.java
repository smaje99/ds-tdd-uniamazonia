package co.edu.udla.ed.contract;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.Queue;

public abstract class AbstractQueueContractTest {

  protected abstract Queue<Integer> create();

  @Test
  void starts_empty() {
    var q = create();
    assertThat(q.isEmpty()).isTrue();
    assertThat(q.size()).isZero();
  }

  @Test
  void enqueue_dequeue_should_be_fifo() {
    var q = create();
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);

    assertThat(q.dequeue()).isEqualTo(1);
    assertThat(q.dequeue()).isEqualTo(2);
    assertThat(q.dequeue()).isEqualTo(3);
    assertThat(q.isEmpty()).isTrue();
  }

  @Test
  void peek_should_not_remove() {
    var q = create();
    q.enqueue(10);
    q.enqueue(20);

    assertThat(q.peek()).isEqualTo(10);
    assertThat(q.size()).isEqualTo(2);
    assertThat(q.dequeue()).isEqualTo(10);
    assertThat(q.dequeue()).isEqualTo(20);
  }

  @Test
  void dequeue_on_empty_should_throw() {
    var q = create();
    assertThatThrownBy(q::dequeue).isInstanceOf(NoSuchElementException.class);
  }

  @Test
  void peek_on_empty_should_throw() {
    var q = create();
    assertThatThrownBy(q::peek).isInstanceOf(NoSuchElementException.class);
  }

  @Test
  void clear_should_reset() {
    var q = create();
    q.enqueue(1);
    q.enqueue(2);

    q.clear();

    assertThat(q.isEmpty()).isTrue();
    assertThatThrownBy(q::dequeue).isInstanceOf(NoSuchElementException.class);
  }

  @Test
  void many_operations_should_keep_order() {
    var q = create();
    q.enqueue(1);
    q.enqueue(2);
    assertThat(q.dequeue()).isEqualTo(1);
    q.enqueue(3);
    q.enqueue(4);
    assertThat(q.dequeue()).isEqualTo(2);
    assertThat(q.dequeue()).isEqualTo(3);
    assertThat(q.dequeue()).isEqualTo(4);
    assertThat(q.isEmpty()).isTrue();
  }

}
