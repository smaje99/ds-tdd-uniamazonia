package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.BTree;
import co.edu.udla.ed.contract.AbstractBTreeContractTest;
import co.edu.udla.ed.impl.scratch.LinkedBTree;

public class LinkedBTreeTest extends AbstractBTreeContractTest {

  @Override
  protected BTree<Integer> create() {
    return new LinkedBTree<>();
  }

}
