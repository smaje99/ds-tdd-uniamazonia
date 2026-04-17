package co.edu.udla.ed.linear;

import co.edu.udla.ed.api.CircularList;
import co.edu.udla.ed.contract.AbstractCircularListContractTest;
import co.edu.udla.ed.impl.linear.LinearCircularSinglyLinkedList;

public class LinearCircularSinglyLinkedListTest extends AbstractCircularListContractTest {

  @Override
  protected CircularList<Integer> create() {
    return new LinearCircularSinglyLinkedList<>();
  }

}
