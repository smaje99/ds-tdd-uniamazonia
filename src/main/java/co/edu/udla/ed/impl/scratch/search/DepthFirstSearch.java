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

  public GraphSearchResult<V> search(Graph<V> graph, V start, V target) {
    List<V> visited = graph.dfs(start);
    boolean found = visited.contains(target);
    List<V> path = found ? graph.shortestPathUnweighted(start, target) : List.of();
    return new GraphSearchResult<>(found, new ArrayList<>(visited), path);
  }

}
