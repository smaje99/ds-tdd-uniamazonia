package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.Queue;
import co.edu.udla.ed.contract.AbstractQueueContractTest;
import co.edu.udla.ed.impl.scratch.StaticQueue;

public class StaticQueueTest extends AbstractQueueContractTest {
  @Override
  protected Queue<Integer> create() {
    return new StaticQueue<>();
  }
}
