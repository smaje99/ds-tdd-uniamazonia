package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.AVLTree;
import co.edu.udla.ed.contract.AbstractAVLContractTest;
import co.edu.udla.ed.impl.scratch.LinkedAVLTree;

public class LinkedAVLTreeTest extends AbstractAVLContractTest {

  @Override
  protected AVLTree<Integer> create() {
    return new LinkedAVLTree<>();
  }

}
