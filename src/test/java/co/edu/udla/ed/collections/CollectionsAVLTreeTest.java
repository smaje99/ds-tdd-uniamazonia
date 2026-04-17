package co.edu.udla.ed.collections;

import co.edu.udla.ed.api.AVLTree;
import co.edu.udla.ed.contract.AbstractAVLContractTest;
import co.edu.udla.ed.impl.collections.CollectionsAVLTree;

public class CollectionsAVLTreeTest extends AbstractAVLContractTest {

  @Override
  protected AVLTree<Integer> create() {
    return new CollectionsAVLTree<>();
  }

}
