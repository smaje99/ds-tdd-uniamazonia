package co.edu.udla.ed.impl.scratch.search;

import java.util.ArrayList;
import java.util.List;

import co.edu.udla.ed.api.GraphSearchResult;
import co.edu.udla.ed.api.WeightedGraph;

/**
 * Weighted shortest-path search backed by the graph Dijkstra operation.
 *
 * @param <V> vertex type
 */
public class WeightedShortestPathSearch<V> {

  /**
   * Finds a minimum-weight path between two vertices.
   *
   * @param graph weighted graph to search
   * @param from source vertex
   * @param to destination vertex
   * @return graph-search result with Dijkstra visit-distance order and path
   */
  public GraphSearchResult<V> search(WeightedGraph<V> graph, V from, V to) {
    List<V> path = graph.shortestPathWeighted(from, to);
    List<V> visited = new ArrayList<>(graph.dijkstraDistances(from).keySet());
    return new GraphSearchResult<>(!path.isEmpty(), visited, path);
  }

}
