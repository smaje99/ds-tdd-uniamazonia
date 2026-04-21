package co.edu.udla.ed.impl.scratch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import co.edu.udla.ed.api.WeightedGraph;

/**
 * Weighted adjacency-list graph with deterministic iteration order.
 *
 * @param <V> the vertex type
 */
public class AdjacencyListWeightedGraph<V> implements WeightedGraph<V> {

  private static final class Distance<V> implements Comparable<Distance<V>> {
    private final V vertex;
    private final double distance;

    private Distance(V vertex, double distance) {
      this.vertex = vertex;
      this.distance = distance;
    }

    @Override
    public int compareTo(Distance<V> other) {
      int byDistance = Double.compare(distance, other.distance);
      if (byDistance != 0) {
        return byDistance;
      }
      return String.valueOf(vertex).compareTo(String.valueOf(other.vertex));
    }
  }

  private static final class Edge<V> implements Comparable<Edge<V>> {
    private final V from;
    private final V to;
    private final double weight;

    private Edge(V from, V to, double weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge<V> other) {
      int byWeight = Double.compare(weight, other.weight);
      if (byWeight != 0) {
        return byWeight;
      }
      int byFrom = String.valueOf(from).compareTo(String.valueOf(other.from));
      if (byFrom != 0) {
        return byFrom;
      }
      return String.valueOf(to).compareTo(String.valueOf(other.to));
    }
  }

  private final boolean directed;
  private final LinkedHashMap<V, LinkedHashMap<V, Double>> adjacency = new LinkedHashMap<>();
  private int edges;

  public AdjacencyListWeightedGraph() {
    this(false);
  }

  public AdjacencyListWeightedGraph(boolean directed) {
    this.directed = directed;
  }

  @Override
  public boolean isDirected() {
    return directed;
  }

  @Override
  public void addVertex(V v) {
    adjacency.computeIfAbsent(v, ignored -> new LinkedHashMap<>());
  }

  @Override
  public void addEdge(V from, V to, double weight) {
    validateWeight(weight);
    addVertex(from);
    addVertex(to);
    boolean isNew = !adjacency.get(from).containsKey(to);
    adjacency.get(from).put(to, weight);
    if (!directed) {
      adjacency.get(to).put(from, weight);
    }
    if (isNew) {
      edges++;
    }
  }

  @Override
  public boolean containsVertex(V v) {
    return adjacency.containsKey(v);
  }

  @Override
  public boolean containsEdge(V from, V to) {
    return adjacency.containsKey(from) && adjacency.get(from).containsKey(to);
  }

  @Override
  public double edgeWeight(V from, V to) {
    if (!containsEdge(from, to)) {
      throw new IllegalArgumentException("Edge does not exist: " + from + " -> " + to);
    }
    return adjacency.get(from).get(to);
  }

  @Override
  public Set<V> vertices() {
    return Collections.unmodifiableSet(adjacency.keySet());
  }

  @Override
  public int vertexCount() {
    return adjacency.size();
  }

  @Override
  public int edgeCount() {
    return edges;
  }

  @Override
  public Map<V, Double> dijkstraDistances(V start) {
    requireVertex(start);
    LinkedHashMap<V, Double> distances = new LinkedHashMap<>();
    for (V vertex : adjacency.keySet()) {
      distances.put(vertex, Double.POSITIVE_INFINITY);
    }
    distances.put(start, 0.0);

    BinaryHeapPriorityQueue<Distance<V>> queue = new BinaryHeapPriorityQueue<>();
    queue.insert(new Distance<>(start, 0.0));

    while (!queue.isEmpty()) {
      Distance<V> current = queue.removeMin();
      if (current.distance > distances.get(current.vertex)) {
        continue;
      }

      for (Map.Entry<V, Double> edge : adjacency.get(current.vertex).entrySet()) {
        V neighbor = edge.getKey();
        double candidate = current.distance + edge.getValue();
        if (candidate < distances.get(neighbor)) {
          distances.put(neighbor, candidate);
          queue.insert(new Distance<>(neighbor, candidate));
        }
      }
    }
    return distances;
  }

  @Override
  public List<V> shortestPathWeighted(V from, V to) {
    if (!containsVertex(from) || !containsVertex(to)) {
      return List.of();
    }
    if (Objects.equals(from, to)) {
      return List.of(from);
    }

    LinkedHashMap<V, Double> distances = new LinkedHashMap<>();
    LinkedHashMap<V, V> previous = new LinkedHashMap<>();
    for (V vertex : adjacency.keySet()) {
      distances.put(vertex, Double.POSITIVE_INFINITY);
    }
    distances.put(from, 0.0);

    BinaryHeapPriorityQueue<Distance<V>> queue = new BinaryHeapPriorityQueue<>();
    queue.insert(new Distance<>(from, 0.0));

    while (!queue.isEmpty()) {
      Distance<V> current = queue.removeMin();
      if (current.distance > distances.get(current.vertex)) {
        continue;
      }
      if (Objects.equals(current.vertex, to)) {
        break;
      }
      for (Map.Entry<V, Double> edge : adjacency.get(current.vertex).entrySet()) {
        V neighbor = edge.getKey();
        double candidate = current.distance + edge.getValue();
        if (candidate < distances.get(neighbor)) {
          distances.put(neighbor, candidate);
          previous.put(neighbor, current.vertex);
          queue.insert(new Distance<>(neighbor, candidate));
        }
      }
    }

    if (Double.isInfinite(distances.get(to))) {
      return List.of();
    }

    ArrayList<V> path = new ArrayList<>();
    V cursor = to;
    while (cursor != null) {
      path.add(cursor);
      if (Objects.equals(cursor, from)) {
        break;
      }
      cursor = previous.get(cursor);
    }
    Collections.reverse(path);
    return !path.isEmpty() && Objects.equals(path.get(0), from) ? path : List.of();
  }

  @Override
  public WeightedGraph<V> minimumSpanningTree() {
    if (directed) {
      throw new IllegalStateException("Minimum spanning tree requires an undirected graph.");
    }
    if (adjacency.isEmpty()) {
      return new AdjacencyListWeightedGraph<>(false);
    }

    List<Edge<V>> edgesToProcess = new ArrayList<>();
    Set<V> seenOrigins = new LinkedHashSet<>();
    for (Map.Entry<V, LinkedHashMap<V, Double>> entry : adjacency.entrySet()) {
      V from = entry.getKey();
      for (Map.Entry<V, Double> edge : entry.getValue().entrySet()) {
        V to = edge.getKey();
        if (!seenOrigins.contains(to)) {
          edgesToProcess.add(new Edge<>(from, to, edge.getValue()));
        }
      }
      seenOrigins.add(from);
    }
    Collections.sort(edgesToProcess);

    UnionFindDisjointSet<V> disjointSet = new UnionFindDisjointSet<>();
    AdjacencyListWeightedGraph<V> mst = new AdjacencyListWeightedGraph<>(false);
    for (V vertex : adjacency.keySet()) {
      disjointSet.makeSet(vertex);
      mst.addVertex(vertex);
    }

    for (Edge<V> edge : edgesToProcess) {
      if (!disjointSet.connected(edge.from, edge.to)) {
        disjointSet.union(edge.from, edge.to);
        mst.addEdge(edge.from, edge.to, edge.weight);
      }
    }

    if (mst.vertexCount() > 0 && mst.edgeCount() != mst.vertexCount() - 1) {
      throw new IllegalStateException("Minimum spanning tree requires a connected graph.");
    }
    return mst;
  }

  @Override
  public void clear() {
    adjacency.clear();
    edges = 0;
  }

  private void validateWeight(double weight) {
    if (Double.isNaN(weight) || weight < 0.0) {
      throw new IllegalArgumentException("Weight must be a non-negative real number.");
    }
  }

  private void requireVertex(V v) {
    if (!adjacency.containsKey(v)) {
      throw new IllegalArgumentException("Vertex does not exist: " + v);
    }
  }
}
