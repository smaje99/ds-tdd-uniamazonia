package co.edu.udla.ed.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Contract for a weighted graph whose edges carry non-negative costs.
 *
 * @param <V> the vertex type
 */
public interface WeightedGraph<V> {

  boolean isDirected();

  void addVertex(V v);

  void addEdge(V from, V to, double weight);

  boolean containsVertex(V v);

  boolean containsEdge(V from, V to);

  double edgeWeight(V from, V to);

  Set<V> vertices();

  default Iterable<V> verticesIterable() {
    return vertices();
  }

  int vertexCount();

  int edgeCount();

  Map<V, Double> dijkstraDistances(V start);

  List<V> shortestPathWeighted(V from, V to);

  WeightedGraph<V> minimumSpanningTree();

  void clear();

}
