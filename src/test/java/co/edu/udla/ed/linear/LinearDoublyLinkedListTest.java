package co.edu.udla.ed.linear;

import co.edu.udla.ed.api.DoublyList;
import co.edu.udla.ed.contract.AbstractDoublyListContractTest;
import co.edu.udla.ed.impl.linear.LinearDoublyLinkedList;

public class LinearDoublyLinkedListTest extends AbstractDoublyListContractTest {

  @Override
  protected DoublyList<Integer> create() {
    return new LinearDoublyLinkedList<>();
  }

}
