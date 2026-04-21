package co.edu.udla.ed.scratch;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.WeightedGraph;
import co.edu.udla.ed.contract.AbstractWeightedGraphContractTest;
import co.edu.udla.ed.impl.scratch.AdjacencyListWeightedGraph;

public class AdjacencyListWeightedGraphTest extends AbstractWeightedGraphContractTest {

  @Override
  protected WeightedGraph<String> createUndirected() {
    return new AdjacencyListWeightedGraph<>(false);
  }

  @Override
  protected WeightedGraph<String> createDirected() {
    return new AdjacencyListWeightedGraph<>(true);
  }

  @Test
  void minimum_spanning_tree_should_have_expected_total_weight() {
    WeightedGraph<String> graph = createUndirected();
    graph.addEdge("A", "B", 1.0);
    graph.addEdge("B", "C", 2.0);
    graph.addEdge("A", "C", 4.0);
    graph.addEdge("C", "D", 3.0);

    WeightedGraph<String> mst = graph.minimumSpanningTree();

    double total = mst.edgeWeight("A", "B") + mst.edgeWeight("B", "C") + mst.edgeWeight("C", "D");
    assertThat(total).isEqualTo(6.0);
  }

}
