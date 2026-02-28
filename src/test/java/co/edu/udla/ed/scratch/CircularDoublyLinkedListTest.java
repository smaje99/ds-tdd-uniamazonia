package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.CircularList;
import co.edu.udla.ed.contract.AbstractCircularListContractTest;
import co.edu.udla.ed.impl.scratch.CircularDoublyLinkedList;

public class CircularDoublyLinkedListTest extends AbstractCircularListContractTest {

  @Override
  protected CircularList<Integer> create() {
    return new CircularDoublyLinkedList<>();
  }

}
