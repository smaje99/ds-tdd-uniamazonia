package co.edu.udla.ed.collections;

import co.edu.udla.ed.api.SimpleList;
import co.edu.udla.ed.contract.AbstractSimpleListContractTest;
import co.edu.udla.ed.impl.collections.CollectionsSimpleList;

public class CollectionsSimpleListTest extends AbstractSimpleListContractTest {

  @Override
  protected SimpleList<Integer> createList() {
    return new CollectionsSimpleList<>();
  }

}
