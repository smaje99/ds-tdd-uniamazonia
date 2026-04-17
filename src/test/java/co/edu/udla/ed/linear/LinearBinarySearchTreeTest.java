package co.edu.udla.ed.linear;

import co.edu.udla.ed.api.BinarySearchTree;
import co.edu.udla.ed.contract.AbstractBSTContractTest;
import co.edu.udla.ed.impl.linear.LinearBinarySearchTree;

public class LinearBinarySearchTreeTest extends AbstractBSTContractTest {

  @Override
  protected BinarySearchTree<Integer> create() {
    return new LinearBinarySearchTree<>();
  }

}
