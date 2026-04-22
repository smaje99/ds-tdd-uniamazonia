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
 * Weighted adjacency-list graph with deterministic vertex and neighbor order.
 *
 * <p>The graph stores each vertex in a {@link LinkedHashMap} and each adjacency
 * list as a nested {@link LinkedHashMap}. Directed graphs store one edge per
 * call to {@link #addEdge(Object, Object, double)}; undirected graphs store the
 * reverse adjacency internally while counting the logical edge once. Edge
 * weights must be non-negative so Dijkstra's algorithm remains valid.</p>
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

  /**
   * Creates an undirected weighted graph.
   */
  public AdjacencyListWeightedGraph() {
    this(false);
  }

  /**
   * Creates a weighted graph with the requested edge direction semantics.
   *
   * @param directed {@code true} for directed edges, {@code false} for
   *        undirected edges
   */
  public AdjacencyListWeightedGraph(boolean directed) {
    this.directed = directed;
  }

  /**
   * Reports whether edges are directional.
   *
   * @return {@code true} for directed graphs; {@code false} for undirected
   *         graphs
   */
  @Override
  public boolean isDirected() {
    return directed;
  }

  /**
   * Adds a vertex if it is not already present.
   *
   * @param v vertex to add
   * @implNote Average time complexity is {@code O(1)}.
   */
  @Override
  public void addVertex(V v) {
    adjacency.computeIfAbsent(v, ignored -> new LinkedHashMap<>());
  }

  /**
   * Adds or updates a weighted edge, creating missing endpoints first.
   *
   * <p>In undirected mode the reverse adjacency is written with the same weight.
   * Replacing an existing edge changes its weight without increasing the logical
   * edge count.</p>
   *
   * @param from source endpoint
   * @param to destination endpoint
   * @param weight non-negative edge weight
   * @throws IllegalArgumentException if {@code weight} is negative or NaN
   * @implNote Average time complexity is {@code O(1)}.
   */
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

  /**
   * Checks whether a vertex exists.
   *
   * @param v vertex to test
   * @return {@code true} when the vertex is present
   * @implNote Average time complexity is {@code O(1)}.
   */
  @Override
  public boolean containsVertex(V v) {
    return adjacency.containsKey(v);
  }

  /**
   * Checks whether an edge exists.
   *
   * @param from source endpoint
   * @param to destination endpoint
   * @return {@code true} when the edge is present
   * @implNote Average time complexity is {@code O(1)}.
   */
  @Override
  public boolean containsEdge(V from, V to) {
    return adjacency.containsKey(from) && adjacency.get(from).containsKey(to);
  }

  /**
   * Returns the weight of an existing edge.
   *
   * @param from source endpoint
   * @param to destination endpoint
   * @return the stored non-negative weight
   * @throws IllegalArgumentException if the edge does not exist
   * @implNote Average time complexity is {@code O(1)}.
   */
  @Override
  public double edgeWeight(V from, V to) {
    if (!containsEdge(from, to)) {
      throw new IllegalArgumentException("Edge does not exist: " + from + " -> " + to);
    }
    return adjacency.get(from).get(to);
  }

  /**
   * Returns the vertices in insertion order.
   *
   * @return an unmodifiable view of the vertex set
   */
  @Override
  public Set<V> vertices() {
    return Collections.unmodifiableSet(adjacency.keySet());
  }

  /**
   * Returns the number of vertices.
   *
   * @return vertex count
   */
  @Override
  public int vertexCount() {
    return adjacency.size();
  }

  /**
   * Returns the logical edge count.
   *
   * @return number of directed edges, or number of undirected edges counted once
   */
  @Override
  public int edgeCount() {
    return edges;
  }

  /**
   * Computes shortest-path distances from one source with Dijkstra's algorithm.
   *
   * @param start source vertex
   * @return a map from every vertex to its distance, using
   *         {@link Double#POSITIVE_INFINITY} for unreachable vertices
   * @throws IllegalArgumentException if {@code start} is not present
   * @implNote Time complexity is {@code O((V + E) log V)} with the binary heap
   *           priority queue used here.
   */
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

  /**
   * Returns one minimum-weight path between two vertices.
   *
   * @param from source vertex
   * @param to destination vertex
   * @return the path from {@code from} to {@code to}, or an empty list when an
   *         endpoint is missing or no route exists
   * @implNote Time complexity is {@code O((V + E) log V)} plus {@code O(k)} to
   *           rebuild a path of length {@code k}.
   */
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

  /**
   * Builds a minimum spanning tree using Kruskal's algorithm.
   *
   * @return a new undirected weighted graph containing the MST edges
   * @throws IllegalStateException if this graph is directed or disconnected
   * @implNote Time complexity is dominated by edge sorting: {@code O(E log E)}.
   */
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

  /**
   * Removes all vertices and edges.
   */
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
