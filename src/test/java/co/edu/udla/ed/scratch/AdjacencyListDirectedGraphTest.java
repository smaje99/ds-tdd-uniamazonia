package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.Graph;
import co.edu.udla.ed.contract.AbstractDirectedGraphContractTest;
import co.edu.udla.ed.impl.scratch.AdjacencyListGraph;

public class AdjacencyListDirectedGraphTest extends AbstractDirectedGraphContractTest {

  @Override
  protected Graph<String> createDirected() {
    return new AdjacencyListGraph<>(true);
  }

  @Override
  protected Graph<String> createUndirected() {
    return new AdjacencyListGraph<>(false);
  }

}
