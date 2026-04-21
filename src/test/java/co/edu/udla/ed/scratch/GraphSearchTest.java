package co.edu.udla.ed.scratch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.impl.scratch.AdjacencyListGraph;
import co.edu.udla.ed.impl.scratch.AdjacencyListWeightedGraph;
import co.edu.udla.ed.impl.scratch.search.BreadthFirstSearch;
import co.edu.udla.ed.impl.scratch.search.DepthFirstSearch;
import co.edu.udla.ed.impl.scratch.search.UnweightedShortestPathSearch;
import co.edu.udla.ed.impl.scratch.search.WeightedShortestPathSearch;

public class GraphSearchTest {

  @Test
  void should_search_with_bfs_and_dfs() {
    AdjacencyListGraph<String> graph = graph();

    var bfs = new BreadthFirstSearch<String>().search(graph, "A", "E");
    var dfs = new DepthFirstSearch<String>().search(graph, "A", "E");

    assertThat(bfs.found()).isTrue();
    assertThat(bfs.visited()).containsExactly("A", "B", "C", "D", "E");
    assertThat(bfs.path()).containsExactly("A", "C", "E");
    assertThat(dfs.found()).isTrue();
    assertThat(dfs.visited()).contains("E");
  }

  @Test
  void should_report_missing_unweighted_path() {
    AdjacencyListGraph<String> graph = graph();
    graph.addVertex("Z");

    var result = new UnweightedShortestPathSearch<String>().search(graph, "A", "Z");

    assertThat(result.found()).isFalse();
    assertThat(result.path()).isEmpty();
  }

  @Test
  void should_reject_unknown_vertex() {
    assertThatThrownBy(() -> new BreadthFirstSearch<String>().search(graph(), "X", "E"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_search_weighted_shortest_path() {
    AdjacencyListWeightedGraph<String> graph = new AdjacencyListWeightedGraph<>(false);
    graph.addEdge("A", "B", 4);
    graph.addEdge("A", "C", 1);
    graph.addEdge("C", "B", 2);

    var result = new WeightedShortestPathSearch<String>().search(graph, "A", "B");

    assertThat(result.found()).isTrue();
    assertThat(result.path()).containsExactly("A", "C", "B");
  }

  private AdjacencyListGraph<String> graph() {
    AdjacencyListGraph<String> graph = new AdjacencyListGraph<>(false);
    graph.addEdge("A", "B");
    graph.addEdge("A", "C");
    graph.addEdge("B", "D");
    graph.addEdge("C", "E");
    return graph;
  }

}
