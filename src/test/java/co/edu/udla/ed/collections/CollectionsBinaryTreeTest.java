package co.edu.udla.ed.collections;

import co.edu.udla.ed.api.BinaryTree;
import co.edu.udla.ed.contract.AbstractBinaryTreeContractTest;
import co.edu.udla.ed.impl.collections.CollectionsBinaryTree;

public class CollectionsBinaryTreeTest extends AbstractBinaryTreeContractTest {

  @Override
  protected BinaryTree<String> create() {
    return new CollectionsBinaryTree<>();
  }

}
