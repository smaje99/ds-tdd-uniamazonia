package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.BinarySearchTree;
import co.edu.udla.ed.contract.AbstractBSTContractTest;
import co.edu.udla.ed.impl.scratch.LinkedBinarySearchTree;

public class LinkedBinarySearchTreeTest extends AbstractBSTContractTest {

  @Override
  protected BinarySearchTree<Integer> create() {
    return new LinkedBinarySearchTree<>();
  }

}
