package co.edu.udla.ed.impl.scratch.search;

import java.util.ArrayList;
import java.util.List;

import co.edu.udla.ed.api.Graph;
import co.edu.udla.ed.api.GraphSearchResult;

/**
 * Depth-first graph search.
 *
 * @param <V> vertex type
 */
public class DepthFirstSearch<V> {

  /**
   * Runs depth-first search and reports whether the target was reached.
   *
   * @param graph graph to search
   * @param start source vertex
   * @param target target vertex
   * @return visited DFS order and a shortest unweighted path when found
   * @implNote Time complexity is {@code O(V + E)} over the reachable component.
   */
  public GraphSearchResult<V> search(Graph<V> graph, V start, V target) {
    List<V> visited = graph.dfs(start);
    boolean found = visited.contains(target);
    List<V> path = found ? graph.shortestPathUnweighted(start, target) : List.of();
    return new GraphSearchResult<>(found, new ArrayList<>(visited), path);
  }

}
