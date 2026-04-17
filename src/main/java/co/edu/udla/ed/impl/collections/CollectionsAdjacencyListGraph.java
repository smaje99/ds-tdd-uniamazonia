package co.edu.udla.ed.impl.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import co.edu.udla.ed.api.Graph;

/**
 * Graph adapter backed by Java collections with deterministic adjacency order.
 *
 * <p>
 * The graph uses adjacency lists stored in a {@link LinkedHashMap}, and each
 * adjacency set is a {@link LinkedHashSet}. This combination preserves vertex
 * insertion order and neighbor insertion order, which makes BFS and DFS stable
 * across runs as long as edges are inserted in the same sequence.
 * </p>
 *
 * <p>
 * In an undirected graph, one logical edge is stored in both endpoint
 * adjacency sets, but the public {@code edgeCount()} still counts it only
 * once.
 * </p>
 *
 * @param <V> the vertex type
 */
public class CollectionsAdjacencyListGraph<V> implements Graph<V> {

  private final boolean directed;
  private final Map<V, LinkedHashSet<V>> adjacency = new LinkedHashMap<>();
  private int edges;

  /**
   * Creates an undirected graph.
   *
   * @implNote Construction is {@code O(1)}.
   */
  public CollectionsAdjacencyListGraph() {
    this(false);
  }

  /**
   * Creates a graph with explicit directed or undirected semantics.
   *
   * @param directed {@code true} for directed edges, {@code false} for
   *        undirected edges
   *
   * @implNote Construction is {@code O(1)}.
   */
  public CollectionsAdjacencyListGraph(boolean directed) {
    this.directed = directed;
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public boolean isDirected() {
    return directed;
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Average-case time complexity is {@code O(1)}.
   */
  @Override
  public void addVertex(V v) {
    adjacency.computeIfAbsent(v, key -> new LinkedHashSet<>());
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * Missing vertices are created automatically. In the undirected case, the
   * reverse adjacency entry is also inserted so the connection remains
   * symmetric.
   * </p>
   *
   * @implNote Average-case time complexity is {@code O(1)}.
   */
  @Override
  public void addEdge(V from, V to) {
    addVertex(from);
    addVertex(to);

    boolean added = adjacency.get(from).add(to);
    if (added) {
      edges++;
    }
    if (!directed) {
      adjacency.get(to).add(from);
    }
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Average-case time complexity is {@code O(1)}.
   */
  @Override
  public boolean containsVertex(V v) {
    return adjacency.containsKey(v);
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Average-case time complexity is {@code O(1)}.
   */
  @Override
  public boolean containsEdge(V from, V to) {
    LinkedHashSet<V> neighbors = adjacency.get(from);
    return neighbors != null && neighbors.contains(to);
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Returning the unmodifiable view is {@code O(1)}.
   */
  @Override
  public Set<V> vertices() {
    return Collections.unmodifiableSet(adjacency.keySet());
  }

  /**
   * {@inheritDoc}
   *
   * @throws IllegalArgumentException if {@code v} is not a vertex of the graph
   *
   * @implNote Average-case time complexity is {@code O(1)}.
   */
  @Override
  public Set<V> neighbors(V v) {
    LinkedHashSet<V> neighbors = adjacency.get(v);
    if (neighbors == null) {
      throw new IllegalArgumentException("Vertex does not exist: " + v);
    }
    return Collections.unmodifiableSet(neighbors);
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public int vertexCount() {
    return adjacency.size();
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(1)}.
   */
  @Override
  public int edgeCount() {
    return edges;
  }

  /**
   * {@inheritDoc}
   *
   * @throws IllegalArgumentException if {@code start} does not exist
   *
   * @implNote Worst-case time complexity is {@code O(V + E)}.
   */
  @Override
  public List<V> bfs(V start) {
    requireVertex(start);

    List<V> order = new ArrayList<>();
    Set<V> visited = new LinkedHashSet<>();
    Deque<V> queue = new ArrayDeque<>();
    visited.add(start);
    queue.addLast(start);

    while (!queue.isEmpty()) {
      V current = queue.removeFirst();
      order.add(current);
      for (V neighbor : adjacency.get(current)) {
        if (visited.add(neighbor)) {
          queue.addLast(neighbor);
        }
      }
    }

    return order;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * Neighbors are pushed in reverse insertion order so the final visitation
   * order matches the natural left-to-right neighbor order stored in the
   * adjacency sets.
   * </p>
   *
   * @throws IllegalArgumentException if {@code start} does not exist
   *
   * @implNote Worst-case time complexity is {@code O(V + E)}.
   */
  @Override
  public List<V> dfs(V start) {
    requireVertex(start);

    List<V> order = new ArrayList<>();
    Set<V> visited = new LinkedHashSet<>();
    Deque<V> stack = new ArrayDeque<>();
    stack.push(start);

    while (!stack.isEmpty()) {
      V current = stack.pop();
      if (!visited.add(current)) {
        continue;
      }

      order.add(current);
      List<V> neighbors = new ArrayList<>(adjacency.get(current));
      for (int i = neighbors.size() - 1; i >= 0; i--) {
        V neighbor = neighbors.get(i);
        if (!visited.contains(neighbor)) {
          stack.push(neighbor);
        }
      }
    }

    return order;
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Worst-case time complexity is {@code O(V + E)}.
   */
  @Override
  public boolean hasPath(V from, V to) {
    if (!containsVertex(from) || !containsVertex(to)) {
      return false;
    }
    if (Objects.equals(from, to)) {
      return true;
    }

    Set<V> visited = new LinkedHashSet<>();
    Deque<V> queue = new ArrayDeque<>();
    visited.add(from);
    queue.addLast(from);

    while (!queue.isEmpty()) {
      V current = queue.removeFirst();
      for (V neighbor : adjacency.get(current)) {
        if (Objects.equals(neighbor, to)) {
          return true;
        }
        if (visited.add(neighbor)) {
          queue.addLast(neighbor);
        }
      }
    }

    return false;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * Breadth-first search ensures that the first discovered route to the target
   * uses the minimum number of edges in an unweighted graph.
   * </p>
   *
   * @implNote Worst-case time complexity is {@code O(V + E)} plus
   *           {@code O(k)} to reconstruct a path of length {@code k}.
   */
  @Override
  public List<V> shortestPathUnweighted(V from, V to) {
    if (!containsVertex(from) || !containsVertex(to)) {
      return List.of();
    }
    if (Objects.equals(from, to)) {
      return List.of(from);
    }

    Map<V, V> parent = new LinkedHashMap<>();
    Set<V> visited = new LinkedHashSet<>();
    Deque<V> queue = new ArrayDeque<>();
    visited.add(from);
    queue.addLast(from);

    while (!queue.isEmpty()) {
      V current = queue.removeFirst();
      for (V neighbor : adjacency.get(current)) {
        if (visited.contains(neighbor)) {
          continue;
        }

        visited.add(neighbor);
        parent.put(neighbor, current);
        if (Objects.equals(neighbor, to)) {
          return buildPath(from, to, parent);
        }
        queue.addLast(neighbor);
      }
    }

    return List.of();
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(V)} in the size of the adjacency map.
   */
  @Override
  public void clear() {
    adjacency.clear();
    edges = 0;
  }

  private List<V> buildPath(V from, V to, Map<V, V> parent) {
    List<V> path = new ArrayList<>();
    V current = to;
    while (current != null) {
      path.add(current);
      if (Objects.equals(current, from)) {
        break;
      }
      current = parent.get(current);
    }
    Collections.reverse(path);
    return !path.isEmpty() && Objects.equals(path.get(0), from) ? path : List.of();
  }

  private void requireVertex(V v) {
    if (!containsVertex(v)) {
      throw new IllegalArgumentException("Vertex does not exist: " + v);
    }
  }

}
