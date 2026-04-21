package co.edu.udla.ed.contract;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.PriorityQueue;

public abstract class AbstractPriorityQueueContractTest {

  protected abstract PriorityQueue<Integer> create();

  @Test
  void starts_empty() {
    var queue = create();

    assertThat(queue.isEmpty()).isTrue();
    assertThat(queue.size()).isZero();
    assertThatThrownBy(queue::peekMin).isInstanceOf(RuntimeException.class);
    assertThatThrownBy(queue::removeMin).isInstanceOf(RuntimeException.class);
  }

  @Test
  void insert_peek_and_remove_should_follow_min_order() {
    var queue = create();
    queue.insert(7);
    queue.insert(3);
    queue.insert(5);
    queue.insert(1);

    assertThat(queue.peekMin()).isEqualTo(1);
    assertThat(queue.removeMin()).isEqualTo(1);
    assertThat(queue.removeMin()).isEqualTo(3);
    assertThat(queue.removeMin()).isEqualTo(5);
    assertThat(queue.removeMin()).isEqualTo(7);
    assertThat(queue.isEmpty()).isTrue();
  }

  @Test
  void duplicates_should_be_kept() {
    var queue = create();
    queue.insert(4);
    queue.insert(4);
    queue.insert(2);
    queue.insert(2);

    assertThat(queue.size()).isEqualTo(4);
    assertThat(queue.removeMin()).isEqualTo(2);
    assertThat(queue.removeMin()).isEqualTo(2);
    assertThat(queue.removeMin()).isEqualTo(4);
    assertThat(queue.removeMin()).isEqualTo(4);
  }

  @Test
  void clear_should_reset() {
    var queue = create();
    queue.insert(3);
    queue.insert(1);

    queue.clear();

    assertThat(queue.size()).isZero();
    assertThat(queue.isEmpty()).isTrue();
  }

  @Test
  void iterator_should_expose_heap_contents_without_losing_elements() {
    var queue = create();
    queue.insert(9);
    queue.insert(1);
    queue.insert(5);

    assertThat(queue).containsExactly(1, 9, 5);
    assertThat(queue.size()).isEqualTo(3);
    assertThat(queue.removeMin()).isEqualTo(1);
  }

}
