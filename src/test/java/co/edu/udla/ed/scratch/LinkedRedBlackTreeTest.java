package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.RedBlackTree;
import co.edu.udla.ed.contract.AbstractRedBlackTreeContractTest;
import co.edu.udla.ed.impl.scratch.LinkedRedBlackTree;

public class LinkedRedBlackTreeTest extends AbstractRedBlackTreeContractTest {

  @Override
  protected RedBlackTree<Integer> create() {
    return new LinkedRedBlackTree<>();
  }

}
