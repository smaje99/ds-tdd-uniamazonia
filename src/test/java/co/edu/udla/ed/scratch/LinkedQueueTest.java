package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.Queue;
import co.edu.udla.ed.contract.AbstractQueueContractTest;
import co.edu.udla.ed.impl.scratch.LinkedQueue;

public class LinkedQueueTest extends AbstractQueueContractTest {
  @Override
  protected Queue<Integer> create() {
    return new LinkedQueue<>();
  }
}
