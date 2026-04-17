package co.edu.udla.ed.linear;

import co.edu.udla.ed.api.Graph;
import co.edu.udla.ed.contract.AbstractGraphContractTest;
import co.edu.udla.ed.impl.linear.LinearAdjacencyListGraph;

public class LinearAdjacencyListGraphTest extends AbstractGraphContractTest {

  @Override
  protected Graph<String> create() {
    return new LinearAdjacencyListGraph<>(false);
  }

}
