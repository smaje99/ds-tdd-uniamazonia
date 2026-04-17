package co.edu.udla.ed.collections;

import co.edu.udla.ed.api.Queue;
import co.edu.udla.ed.contract.AbstractQueueContractTest;
import co.edu.udla.ed.impl.collections.CollectionsQueue;

public class CollectionsQueueTest extends AbstractQueueContractTest {

  @Override
  protected Queue<Integer> create() {
    return new CollectionsQueue<>();
  }

}
