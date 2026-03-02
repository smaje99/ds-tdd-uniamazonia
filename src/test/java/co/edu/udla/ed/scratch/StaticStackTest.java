package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.Stack;
import co.edu.udla.ed.contract.AbstractStackContractTest;
import co.edu.udla.ed.impl.scratch.StaticStack;

public class StaticStackTest extends AbstractStackContractTest {
  @Override
  protected Stack<Integer> create() {
    return new StaticStack<>();
  }
}
