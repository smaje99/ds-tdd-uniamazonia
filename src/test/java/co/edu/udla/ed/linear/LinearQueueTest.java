package co.edu.udla.ed.linear;

import co.edu.udla.ed.api.Queue;
import co.edu.udla.ed.contract.AbstractQueueContractTest;
import co.edu.udla.ed.impl.linear.LinearQueue;

public class LinearQueueTest extends AbstractQueueContractTest {

  @Override
  protected Queue<Integer> create() {
    return new LinearQueue<>();
  }

}
