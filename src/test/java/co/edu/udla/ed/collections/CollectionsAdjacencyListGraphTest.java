package co.edu.udla.ed.collections;

import co.edu.udla.ed.api.Graph;
import co.edu.udla.ed.contract.AbstractGraphContractTest;
import co.edu.udla.ed.impl.collections.CollectionsAdjacencyListGraph;

public class CollectionsAdjacencyListGraphTest extends AbstractGraphContractTest {

  @Override
  protected Graph<String> create() {
    return new CollectionsAdjacencyListGraph<>(false);
  }

}
