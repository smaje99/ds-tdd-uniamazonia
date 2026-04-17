package co.edu.udla.ed.linear;

import co.edu.udla.ed.api.BinaryTree;
import co.edu.udla.ed.contract.AbstractBinaryTreeContractTest;
import co.edu.udla.ed.impl.linear.LinearBinaryTree;

public class LinearBinaryTreeTest extends AbstractBinaryTreeContractTest {

  @Override
  protected BinaryTree<String> create() {
    return new LinearBinaryTree<>();
  }

}
