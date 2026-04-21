package co.edu.udla.ed.scratch;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.PriorityQueue;
import co.edu.udla.ed.contract.AbstractPriorityQueueContractTest;
import co.edu.udla.ed.impl.scratch.BinaryHeapPriorityQueue;

public class BinaryHeapPriorityQueueTest extends AbstractPriorityQueueContractTest {

  @Override
  protected PriorityQueue<Integer> create() {
    return new BinaryHeapPriorityQueue<>();
  }

  @Test
  void iterator_should_follow_heap_internal_order() {
    BinaryHeapPriorityQueue<Integer> queue = new BinaryHeapPriorityQueue<>();
    queue.insert(7);
    queue.insert(3);
    queue.insert(5);
    queue.insert(1);

    assertThat(queue).containsExactly(1, 3, 5, 7);
  }

}
