package co.edu.udla.ed.impl.scratch.search;

import java.util.List;

import co.edu.udla.ed.api.Graph;
import co.edu.udla.ed.api.GraphSearchResult;

/**
 * Unweighted shortest-path search backed by BFS.
 *
 * @param <V> vertex type
 */
public class UnweightedShortestPathSearch<V> {

  public GraphSearchResult<V> search(Graph<V> graph, V from, V to) {
    List<V> path = graph.shortestPathUnweighted(from, to);
    List<V> visited = graph.bfs(from);
    return new GraphSearchResult<>(!path.isEmpty(), visited, path);
  }

}
