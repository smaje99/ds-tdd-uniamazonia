package co.edu.udla.ed.collections;

import co.edu.udla.ed.api.DoublyList;
import co.edu.udla.ed.contract.AbstractDoublyListContractTest;
import co.edu.udla.ed.impl.collections.CollectionsDoublyLinkedList;

public class CollectionsDoublyLinkedListTest extends AbstractDoublyListContractTest {

  @Override
  protected DoublyList<Integer> create() {
    return new CollectionsDoublyLinkedList<>();
  }

}
