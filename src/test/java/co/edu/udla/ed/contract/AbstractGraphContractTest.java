package co.edu.udla.ed.contract;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.Graph;

public abstract class AbstractGraphContractTest {

  protected abstract Graph<String> create();

  private Graph<String> sampleUndirected() {
    var g = create();
    // orden importante para BFS/DFS determinista
    g.addEdge("A", "B");
    g.addEdge("A", "C");
    g.addEdge("B", "D");
    g.addEdge("C", "D");
    g.addEdge("D", "E");
    return g;
  }

  @Test
  void add_vertices_edges_counts() {
    var g = sampleUndirected();

    assertThat(g.isDirected()).isFalse();
    assertThat(g.vertexCount()).isEqualTo(5);
    assertThat(g.edgeCount()).isEqualTo(5);

    assertThat(g.containsVertex("A")).isTrue();
    assertThat(g.containsEdge("A", "B")).isTrue();
    assertThat(g.containsEdge("B", "A")).isTrue(); // no dirigido
  }

  @Test
  void neighbors_should_work() {
    var g = sampleUndirected();
    assertThat(g.neighbors("A")).containsExactly("B", "C");
    assertThat(g.neighbors("D")).contains("B", "C", "E");
  }

  @Test
  void bfs_should_visit_by_layers() {
    var g = sampleUndirected();
    // BFS desde A: A, B, C, D, E (según inserción de vecinos)
    assertThat(g.bfs("A")).containsExactly("A", "B", "C", "D", "E");
  }

  @Test
  void dfs_should_visit_depth_first_deterministic() {
    var g = sampleUndirected();
    // Con orden de vecinos B, C para A, y el push en reversa:
    // DFS típico: A, B, D, C, E (puede variar según implementación)
    assertThat(g.dfs("A")).containsExactly("A", "B", "D", "C", "E");
  }

  @Test
  void hasPath_should_work() {
    var g = sampleUndirected();
    assertThat(g.hasPath("A", "E")).isTrue();
    assertThat(g.hasPath("E", "A")).isTrue(); // no dirigido
    assertThat(g.hasPath("A", "Z")).isFalse();
  }

  @Test
  void shortestPathUnweighted_should_return_min_edges_path() {
    var g = sampleUndirected();
    assertThat(g.shortestPathUnweighted("A", "E"))
        .containsExactly("A", "B", "D", "E");
  }

  @Test
  void bfs_on_missing_vertex_should_throw() {
    var g = create();
    assertThatThrownBy(() -> g.bfs("X"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void clear_should_reset() {
    var g = sampleUndirected();
    g.clear();
    assertThat(g.vertexCount()).isZero();
    assertThat(g.edgeCount()).isZero();
    assertThat(g.vertices()).isEmpty();
  }

}
