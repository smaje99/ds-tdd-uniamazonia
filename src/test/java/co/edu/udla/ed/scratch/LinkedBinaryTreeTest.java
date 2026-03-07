package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.BinaryTree;
import co.edu.udla.ed.contract.AbstractBinaryTreeContractTest;
import co.edu.udla.ed.impl.scratch.LinkedBinaryTree;

public class LinkedBinaryTreeTest extends AbstractBinaryTreeContractTest {

  @Override
  protected BinaryTree<String> create() {
    return new LinkedBinaryTree<>();
  }

}
