package co.edu.udla.ed.collections;

import co.edu.udla.ed.api.Stack;
import co.edu.udla.ed.contract.AbstractStackContractTest;
import co.edu.udla.ed.impl.collections.CollectionsStack;

public class CollectionsStackTest extends AbstractStackContractTest {

  @Override
  protected Stack<Integer> create() {
    return new CollectionsStack<>();
  }

}
