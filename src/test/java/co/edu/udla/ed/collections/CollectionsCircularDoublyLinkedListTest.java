package co.edu.udla.ed.collections;

import co.edu.udla.ed.api.CircularList;
import co.edu.udla.ed.contract.AbstractCircularListContractTest;
import co.edu.udla.ed.impl.collections.CollectionsCircularDoublyLinkedList;

public class CollectionsCircularDoublyLinkedListTest extends AbstractCircularListContractTest {

  @Override
  protected CircularList<Integer> create() {
    return new CollectionsCircularDoublyLinkedList<>();
  }

}
