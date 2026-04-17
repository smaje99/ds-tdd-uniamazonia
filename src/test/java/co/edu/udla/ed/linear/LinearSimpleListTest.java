package co.edu.udla.ed.linear;

import co.edu.udla.ed.api.SimpleList;
import co.edu.udla.ed.contract.AbstractSimpleListContractTest;
import co.edu.udla.ed.impl.linear.LinearSimpleList;

public class LinearSimpleListTest extends AbstractSimpleListContractTest {

  @Override
  protected SimpleList<Integer> createList() {
    return new LinearSimpleList<>();
  }

}
