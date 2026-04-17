package co.edu.udla.ed.linear;

import co.edu.udla.ed.api.CircularList;
import co.edu.udla.ed.contract.AbstractCircularListContractTest;
import co.edu.udla.ed.impl.linear.LinearCircularDoublyLinkedList;

public class LinearCircularDoublyLinkedListTest extends AbstractCircularListContractTest {

  @Override
  protected CircularList<Integer> create() {
    return new LinearCircularDoublyLinkedList<>();
  }

}
