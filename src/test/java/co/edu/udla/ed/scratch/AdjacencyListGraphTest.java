package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.Graph;
import co.edu.udla.ed.contract.AbstractGraphContractTest;
import co.edu.udla.ed.impl.scratch.AdjacencyListGraph;

public class AdjacencyListGraphTest extends AbstractGraphContractTest {

  @Override
  protected Graph<String> create() {
    return new AdjacencyListGraph<>(false);
  }

}
