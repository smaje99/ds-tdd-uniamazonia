package co.edu.udla.ed.contract;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.WeightedGraph;

public abstract class AbstractWeightedGraphContractTest {

  protected abstract WeightedGraph<String> createUndirected();

  protected abstract WeightedGraph<String> createDirected();

  private WeightedGraph<String> sampleUndirected() {
    var graph = createUndirected();
    graph.addEdge("A", "B", 4.0);
    graph.addEdge("A", "C", 2.0);
    graph.addEdge("B", "C", 1.0);
    graph.addEdge("B", "D", 5.0);
    graph.addEdge("C", "D", 8.0);
    graph.addEdge("C", "E", 10.0);
    graph.addEdge("D", "E", 2.0);
    return graph;
  }

  @Test
  void add_vertices_edges_and_weights_should_work() {
    var graph = sampleUndirected();

    assertThat(graph.isDirected()).isFalse();
    assertThat(graph.vertexCount()).isEqualTo(5);
    assertThat(graph.edgeCount()).isEqualTo(7);
    assertThat(graph.containsEdge("A", "B")).isTrue();
    assertThat(graph.containsEdge("B", "A")).isTrue();
    assertThat(graph.edgeWeight("A", "B")).isEqualTo(4.0);
  }

  @Test
  void dijkstra_should_compute_min_distances() {
    var graph = sampleUndirected();
    LinkedHashMap<String, Double> expected = new LinkedHashMap<>();
    expected.put("A", 0.0);
    expected.put("B", 3.0);
    expected.put("C", 2.0);
    expected.put("D", 8.0);
    expected.put("E", 10.0);

    assertThat(graph.dijkstraDistances("A")).containsExactlyEntriesOf(expected);
  }

  @Test
  void shortestPathWeighted_should_return_lowest_cost_path() {
    var graph = sampleUndirected();

    assertThat(graph.shortestPathWeighted("A", "E")).containsExactly("A", "C", "B", "D", "E");
  }

  @Test
  void minimumSpanningTree_should_keep_n_minus_one_edges() {
    var graph = sampleUndirected();

    WeightedGraph<String> mst = graph.minimumSpanningTree();

    assertThat(mst.vertexCount()).isEqualTo(5);
    assertThat(mst.edgeCount()).isEqualTo(4);
    assertThat(mst.containsEdge("B", "C")).isTrue();
    assertThat(mst.containsEdge("D", "E")).isTrue();
  }

  @Test
  void negative_or_nan_weights_should_throw() {
    var graph = createUndirected();

    assertThatThrownBy(() -> graph.addEdge("A", "B", -1.0)).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> graph.addEdge("A", "B", Double.NaN)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void minimumSpanningTree_should_reject_directed_or_disconnected_graphs() {
    var directed = createDirected();
    directed.addEdge("A", "B", 1.0);
    directed.addEdge("B", "C", 2.0);

    assertThatThrownBy(directed::minimumSpanningTree).isInstanceOf(IllegalStateException.class);

    var disconnected = createUndirected();
    disconnected.addEdge("A", "B", 1.0);
    disconnected.addEdge("C", "D", 2.0);

    assertThatThrownBy(disconnected::minimumSpanningTree).isInstanceOf(IllegalStateException.class);
  }

  @Test
  void clear_should_reset() {
    var graph = sampleUndirected();

    graph.clear();

    assertThat(graph.vertexCount()).isZero();
    assertThat(graph.edgeCount()).isZero();
    assertThat(graph.vertices()).isEmpty();
  }

}
