package co.edu.udla.ed.linear;

import co.edu.udla.ed.api.AVLTree;
import co.edu.udla.ed.contract.AbstractAVLContractTest;
import co.edu.udla.ed.impl.linear.LinearAVLTree;

public class LinearAVLTreeTest extends AbstractAVLContractTest {

  @Override
  protected AVLTree<Integer> create() {
    return new LinearAVLTree<>();
  }

}
