package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.DoublyList;
import co.edu.udla.ed.contract.AbstractDoublyListContractTest;
import co.edu.udla.ed.impl.scratch.DoublyLinkedList;

public class DoublyLinkedListTest extends AbstractDoublyListContractTest {

  @Override
  protected DoublyList<Integer> create() {
    return new DoublyLinkedList<>();
  }

}
