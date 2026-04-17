package co.edu.udla.ed.collections;

import co.edu.udla.ed.api.BinarySearchTree;
import co.edu.udla.ed.contract.AbstractBSTContractTest;
import co.edu.udla.ed.impl.collections.CollectionsBinarySearchTree;

public class CollectionsBinarySearchTreeTest extends AbstractBSTContractTest {

  @Override
  protected BinarySearchTree<Integer> create() {
    return new CollectionsBinarySearchTree<>();
  }

}
