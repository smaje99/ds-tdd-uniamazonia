package co.edu.udla.ed.contract;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.Graph;

public abstract class AbstractDirectedGraphContractTest {

  protected abstract Graph<String> createDirected();

  protected abstract Graph<String> createUndirected();

  private Graph<String> sampleDag() {
    var graph = createDirected();
    graph.addEdge("A", "B");
    graph.addEdge("A", "C");
    graph.addEdge("B", "D");
    graph.addEdge("C", "D");
    graph.addEdge("D", "E");
    return graph;
  }

  @Test
  void directed_edges_should_not_be_symmetric() {
    var graph = sampleDag();

    assertThat(graph.isDirected()).isTrue();
    assertThat(graph.containsEdge("A", "B")).isTrue();
    assertThat(graph.containsEdge("B", "A")).isFalse();
    assertThat(graph.edgeCount()).isEqualTo(5);
  }

  @Test
  void bfs_dfs_and_shortest_path_should_follow_direction() {
    var graph = sampleDag();

    assertThat(graph.bfs("A")).containsExactly("A", "B", "C", "D", "E");
    assertThat(graph.dfs("A")).containsExactly("A", "B", "D", "E", "C");
    assertThat(graph.shortestPathUnweighted("A", "E")).containsExactly("A", "B", "D", "E");
    assertThat(graph.hasPath("E", "A")).isFalse();
  }

  @Test
  void topological_sort_should_work_for_dag() {
    var graph = sampleDag();

    assertThat(graph.topologicalSort()).containsExactly("A", "B", "C", "D", "E");
    assertThat(graph.topologicalSortIterable()).containsExactly("A", "B", "C", "D", "E");
  }

  @Test
  void topological_sort_should_reject_cycles_and_undirected_graphs() {
    var cyclic = createDirected();
    cyclic.addEdge("A", "B");
    cyclic.addEdge("B", "C");
    cyclic.addEdge("C", "A");

    assertThatThrownBy(cyclic::topologicalSort).isInstanceOf(IllegalStateException.class);

    var undirected = createUndirected();
    undirected.addEdge("A", "B");
    undirected.addEdge("B", "C");

    assertThatThrownBy(undirected::topologicalSort).isInstanceOf(IllegalStateException.class);
  }

}
