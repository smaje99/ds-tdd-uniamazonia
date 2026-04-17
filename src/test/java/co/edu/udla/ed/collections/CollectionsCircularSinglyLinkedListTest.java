package co.edu.udla.ed.collections;

import co.edu.udla.ed.api.CircularList;
import co.edu.udla.ed.contract.AbstractCircularListContractTest;
import co.edu.udla.ed.impl.collections.CollectionsCircularSinglyLinkedList;

public class CollectionsCircularSinglyLinkedListTest extends AbstractCircularListContractTest {

  @Override
  protected CircularList<Integer> create() {
    return new CollectionsCircularSinglyLinkedList<>();
  }

}
