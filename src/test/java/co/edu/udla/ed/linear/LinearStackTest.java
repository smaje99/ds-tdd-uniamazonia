package co.edu.udla.ed.linear;

import co.edu.udla.ed.api.Stack;
import co.edu.udla.ed.contract.AbstractStackContractTest;
import co.edu.udla.ed.impl.linear.LinearStack;

public class LinearStackTest extends AbstractStackContractTest {

  @Override
  protected Stack<Integer> create() {
    return new LinearStack<>();
  }

}
