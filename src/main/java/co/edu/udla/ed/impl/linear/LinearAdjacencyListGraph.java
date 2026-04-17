package co.edu.udla.ed.impl.linear;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import co.edu.udla.ed.api.Graph;

/**
 * Graph implementation that favors iterative logic and linear adjacency scans.
 *
 * <p>
 * Vertices are still stored in an insertion-ordered map so traversal output
 * stays deterministic, but each adjacency list is a plain {@link List}. That
 * means edge existence checks and visited-set checks can become linear in the
 * number of already encountered vertices or neighbors. This class is therefore
 * intentionally less efficient than the hash-based graph wrappers, which makes
 * the cost of repeated linear scans easier to discuss.
 * </p>
 *
 * @param <V> the vertex type
 */
public class LinearAdjacencyListGraph<V> implements Graph<V> {

  private final boolean directed;
  private final Map<V, List<V>> adjacency = new LinkedHashMap<>();
  private int edges;

  /**
   * Creates an undirected graph.
   *
   * @implNote Construction is {@code O(1)}.
   */
  public LinearAdjacencyListGraph() {
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
  public LinearAdjacencyListGraph(boolean directed) {
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
   * @implNote Average-case time complexity is {@code O(1)} because vertex
   *           lookup still uses a hash-based map.
   */
  @Override
  public void addVertex(V v) {
    adjacency.computeIfAbsent(v, key -> new LinkedList<>());
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * Duplicate neighbor prevention is checked by scanning the existing adjacency
   * list, so the cost depends on the degree of the origin vertex.
   * </p>
   *
   * @implNote Time complexity is {@code O(deg(from) + deg(to))} in the
   *           undirected case and {@code O(deg(from))} in the directed case.
   */
  @Override
  public void addEdge(V from, V to) {
    addVertex(from);
    addVertex(to);

    boolean added = addNeighborIfMissing(adjacency.get(from), to);
    if (added) {
      edges++;
    }
    if (!directed) {
      addNeighborIfMissing(adjacency.get(to), from);
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
   * @implNote Time complexity is {@code O(deg(from))}.
   */
  @Override
  public boolean containsEdge(V from, V to) {
    List<V> neighbors = adjacency.get(from);
    if (neighbors == null) {
      return false;
    }
    for (V neighbor : neighbors) {
      if (Objects.equals(neighbor, to)) {
        return true;
      }
    }
    return false;
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Time complexity is {@code O(V)} because the method copies the
   *           current vertex order into a new set view.
   */
  @Override
  public Set<V> vertices() {
    return Collections.unmodifiableSet(new LinkedHashSet<>(adjacency.keySet()));
  }

  /**
   * {@inheritDoc}
   *
   * @throws IllegalArgumentException if {@code v} is not a vertex of the graph
   *
   * @implNote Time complexity is {@code O(deg(v))} because neighbors are copied
   *           into an order-preserving set.
   */
  @Override
  public Set<V> neighbors(V v) {
    List<V> neighbors = adjacency.get(v);
    if (neighbors == null) {
      throw new IllegalArgumentException("Vertex does not exist: " + v);
    }
    return Collections.unmodifiableSet(new LinkedHashSet<>(neighbors));
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
   * <p>
   * Because visited membership is tracked with a list and checked linearly, the
   * traversal can be substantially more expensive than the usual
   * hash-set-backed {@code O(V + E)} BFS.
   * </p>
   *
   * @throws IllegalArgumentException if {@code start} does not exist
   *
   * @implNote Worst-case time complexity is {@code O(V * (V + E))}.
   */
  @Override
  public List<V> bfs(V start) {
    requireVertex(start);

    List<V> order = new ArrayList<>();
    List<V> visited = new ArrayList<>();
    Deque<V> queue = new ArrayDeque<>();
    visited.add(start);
    queue.addLast(start);

    while (!queue.isEmpty()) {
      V current = queue.removeFirst();
      order.add(current);
      for (V neighbor : adjacency.get(current)) {
        if (!containsValue(visited, neighbor)) {
          visited.add(neighbor);
          queue.addLast(neighbor);
        }
      }
    }
    return order;
  }

  /**
   * {@inheritDoc}
   *
   * @throws IllegalArgumentException if {@code start} does not exist
   *
   * @implNote Worst-case time complexity is {@code O(V * (V + E))} because
   *           visited checks are linear.
   */
  @Override
  public List<V> dfs(V start) {
    requireVertex(start);

    List<V> order = new ArrayList<>();
    List<V> visited = new ArrayList<>();
    Deque<V> stack = new ArrayDeque<>();
    stack.push(start);

    while (!stack.isEmpty()) {
      V current = stack.pop();
      if (containsValue(visited, current)) {
        continue;
      }

      visited.add(current);
      order.add(current);

      List<V> neighbors = adjacency.get(current);
      for (int i = neighbors.size() - 1; i >= 0; i--) {
        V neighbor = neighbors.get(i);
        if (!containsValue(visited, neighbor)) {
          stack.push(neighbor);
        }
      }
    }

    return order;
  }

  /**
   * {@inheritDoc}
   *
   * @implNote Worst-case time complexity is {@code O(V * (V + E))}.
   */
  @Override
  public boolean hasPath(V from, V to) {
    if (!containsVertex(from) || !containsVertex(to)) {
      return false;
    }
    if (Objects.equals(from, to)) {
      return true;
    }

    List<V> visited = new ArrayList<>();
    Deque<V> queue = new ArrayDeque<>();
    visited.add(from);
    queue.addLast(from);

    while (!queue.isEmpty()) {
      V current = queue.removeFirst();
      for (V neighbor : adjacency.get(current)) {
        if (Objects.equals(neighbor, to)) {
          return true;
        }
        if (!containsValue(visited, neighbor)) {
          visited.add(neighbor);
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
   * The algorithm still uses breadth-first search, so it keeps the shortest
   * path in number of edges. However, repeated linear membership checks make
   * the traversal asymptotically more expensive than the hash-based graph
   * wrappers.
   * </p>
   *
   * @implNote Worst-case time complexity is {@code O(V * (V + E))} plus
   *           {@code O(k)} to rebuild a path of length {@code k}.
   */
  @Override
  public List<V> shortestPathUnweighted(V from, V to) {
    if (!containsVertex(from) || !containsVertex(to)) {
      return List.of();
    }
    if (Objects.equals(from, to)) {
      return List.of(from);
    }

    List<V> visited = new ArrayList<>();
    Map<V, V> parent = new LinkedHashMap<>();
    Deque<V> queue = new ArrayDeque<>();
    visited.add(from);
    queue.addLast(from);

    while (!queue.isEmpty()) {
      V current = queue.removeFirst();
      for (V neighbor : adjacency.get(current)) {
        if (containsValue(visited, neighbor)) {
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
   * @implNote Time complexity is {@code O(V)} in the size of the vertex map.
   */
  @Override
  public void clear() {
    adjacency.clear();
    edges = 0;
  }

  private boolean addNeighborIfMissing(List<V> neighbors, V candidate) {
    for (V neighbor : neighbors) {
      if (Objects.equals(neighbor, candidate)) {
        return false;
      }
    }
    neighbors.add(candidate);
    return true;
  }

  private boolean containsValue(List<V> values, V candidate) {
    for (V value : values) {
      if (Objects.equals(value, candidate)) {
        return true;
      }
    }
    return false;
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
