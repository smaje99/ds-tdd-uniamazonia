package co.edu.udla.ed.impl.scratch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import co.edu.udla.ed.api.Graph;

/**
 * Graph implementation backed by an adjacency-list representation.
 *
 * <p>This class stores each vertex as a key in a map and associates it with the
 * set of its adjacent vertices. The adjacency sets are {@link LinkedHashSet}
 * instances, so neighbor iteration follows insertion order. That detail makes
 * graph traversals deterministic as long as vertices and edges are added in a
 * deterministic sequence.</p>
 *
 * <p>The implementation can represent either directed or undirected graphs. In
 * the undirected case, each logical edge is stored in both adjacency sets, but
 * the {@code edges} counter still records it as a single connection. This makes
 * the internal representation easy to reason about while keeping the public edge
 * count aligned with the abstract graph model students usually study.</p>
 *
 * <p>This representation is especially convenient for sparse graphs because it
 * stores only the edges that actually exist, instead of reserving space for all
 * possible vertex pairs. As a result, adjacency queries and neighbor iteration
 * are efficient, and traversals such as breadth-first search and depth-first
 * search naturally run in time proportional to the number of vertices and edges
 * they actually explore.</p>
 *
 * @param <V> the type of value stored in each vertex
 */
public class AdjacencyListGraph<V> implements Graph<V> {

  /**
   * Indicates whether the graph should interpret edges as directed.
   *
   * <p>This flag is read in constant time, so checking it costs {@code O(1)}.</p>
   */
  private final boolean directed;

  /**
   * Maps each vertex to the set of its adjacent vertices.
   *
   * <p>Average-case vertex lookup in this map is {@code O(1)} because it is
   * implemented with {@link HashMap}.</p>
   */
  private final Map<V, Set<V>> adj = new HashMap<>();

  /**
   * Stores the number of logical edges in the graph.
   *
   * <p>Keeping this counter updated allows {@link #edgeCount()} to run in
   * {@code O(1)} instead of recounting edges from the adjacency lists.</p>
   */
  private int edges = 0;

  /**
   * Creates an undirected graph.
   *
   * <p>This constructor delegates to the main constructor with
   * {@code directed = false}. Its time complexity is {@code O(1)}.</p>
   */
  public AdjacencyListGraph() {
    this(false);
  }

  /**
   * Creates a graph whose edge semantics are controlled by {@code directed}.
   *
   * @param directed {@code true} to create a directed graph; {@code false} to
   *                 create an undirected graph
   *
   * @implNote The constructor only stores the configuration flag and performs
   *           constant-time initialization, so its time complexity is
   *           {@code O(1)}.
   */
  public AdjacencyListGraph(boolean directed) {
    this.directed = directed;
  }

  /**
   * Returns whether this graph is directed.
   *
   * <p>The result is read directly from the {@code directed} field, so the
   * operation runs in {@code O(1)} time.</p>
   *
   * @return {@code true} if edges are oriented; {@code false} if they are
   *         bidirectional
   */
  @Override
  public boolean isDirected() {
    return directed;
  }

  /**
   * Adds a vertex if it is not already present.
   *
   * <p>The adjacency list of each new vertex is a {@link LinkedHashSet}, which
   * preserves the order in which neighbors are inserted. If the vertex already
   * exists, the method leaves the graph unchanged.</p>
   *
   * @param v the vertex to add
   *
   * @implNote Average-case time complexity is {@code O(1)} because the method
   *           performs a single hash-based lookup and, when necessary, creates
   *           an empty adjacency set.
   */
  @Override
  public void addVertex(V v) {
    adj.computeIfAbsent(v, k -> new LinkedHashSet<>());
  }

  /**
   * Adds an edge from {@code from} to {@code to}.
   *
   * <p>If either endpoint does not exist yet, it is created automatically. In
   * an undirected graph, the reverse connection is also inserted so both
   * adjacency sets stay symmetric. The {@code edges} counter increases only
   * when the logical edge did not already exist.</p>
   *
   * <p>Students should notice an important distinction here: an undirected edge
   * is represented internally by two adjacency entries, but it still counts as
   * one logical edge in the public API. That is why the method increments
   * {@code edges} only once.</p>
   *
   * @param from the origin vertex
   * @param to the destination vertex
   *
   * @implNote Average-case time complexity is {@code O(1)} because the method
   *           performs a constant number of hash-map and hash-set operations.
   */
  @Override
  public void addEdge(V from, V to) {
    addVertex(from);
    addVertex(to);

    boolean added = adj.get(from).add(to);
    if (added) {
      edges++;
      if (!directed) {
        adj.get(to).add(from);
      }
    } else {
      if (!directed)
        adj.get(to).add(from);
    }
  }

  /**
   * Checks whether the graph contains {@code v} as a vertex.
   *
   * @param v the vertex to search for
   * @return {@code true} if the vertex exists; {@code false} otherwise
   *
   * @implNote Average-case time complexity is {@code O(1)} due to the
   *           underlying {@link HashMap} lookup.
   */
  @Override
  public boolean containsVertex(V v) {
    return adj.containsKey(v);
  }

  /**
   * Checks whether the edge from {@code from} to {@code to} exists.
   *
   * @param from the origin vertex
   * @param to the destination vertex
   * @return {@code true} if the edge exists; {@code false} otherwise
   *
   * @implNote Average-case time complexity is {@code O(1)}: one hash-map lookup
   *           to find the adjacency set of {@code from} and one hash-set lookup
   *           to test whether {@code to} is present.
   */
  @Override
  public boolean containsEdge(V from, V to) {
    if (!adj.containsKey(from))
      return false;
    return adj.get(from).contains(to);
  }

  /**
   * Returns an unmodifiable view of the vertex set.
   *
   * <p>The returned set is a read-only wrapper around the graph's internal
   * vertex set, so callers can inspect the vertices without modifying the
   * structure through this view.</p>
   *
   * @return the vertices currently stored in the graph
   *
   * @implNote Returning the wrapper is {@code O(1)} because the method does not
   *           copy the vertices.
   */
  @Override
  public Set<V> vertices() {
    return Collections.unmodifiableSet(adj.keySet());
  }

  /**
   * Returns an unmodifiable view of the neighbors of {@code v}.
   *
   * <p>Because the internal adjacency set is a {@link LinkedHashSet}, iterating
   * over the returned view preserves neighbor insertion order. This matters for
   * reproducible BFS and DFS results.</p>
   *
   * @param v the vertex whose neighbors are requested
   * @return the adjacent vertices of {@code v}
   * @throws IllegalArgumentException if {@code v} is not a vertex of the graph
   *
   * @implNote Average-case time complexity is {@code O(1)} because the method
   *           performs one hash-map lookup and returns an unmodifiable wrapper
   *           around the existing set instead of copying it.
   */
  @Override
  public Set<V> neighbors(V v) {
    Set<V> n = adj.get(v);
    if (n == null)
      throw new IllegalArgumentException("Vertex does not exist: " + v);
    return Collections.unmodifiableSet(n);
  }

  /**
   * Returns the current number of vertices.
   *
   * @return the number of vertices in the graph
   *
   * @implNote Time complexity is {@code O(1)} because the count is obtained
   *           directly from the adjacency map.
   */
  @Override
  public int vertexCount() {
    return adj.size();
  }

  /**
   * Returns the current number of logical edges.
   *
   * @return the number of edges in the graph
   *
   * @implNote Time complexity is {@code O(1)} because the value is maintained
   *           incrementally in the {@code edges} field.
   */
  @Override
  public int edgeCount() {
    return edges;
  }

  /**
   * Performs a breadth-first traversal from {@code start}.
   *
   * <p>The traversal visits vertices in increasing distance from the start
   * vertex. Because adjacency sets preserve insertion order, the result is
   * deterministic for a fixed sequence of edge insertions.</p>
   *
   * <p>In graph analysis, breadth-first search is useful when students need to
   * explore vertices layer by layer. Every reachable vertex is enqueued at most
   * once and every outgoing adjacency is inspected once during the traversal.</p>
   *
   * @param start the vertex where the traversal begins
   * @return the BFS visitation order
   * @throws IllegalArgumentException if {@code start} is not in the graph
   *
   * @implNote Time complexity is {@code O(V + E)} over the reachable portion of
   *           the graph, and worst-case {@code O(V + E)} when the entire graph
   *           is reachable from {@code start}.
   */
  @Override
  public List<V> bfs(V start) {
    requireVertex(start);

    List<V> order = new ArrayList<>();
    Set<V> visited = new HashSet<>();
    Deque<V> q = new ArrayDeque<>();

    visited.add(start);
    q.addLast(start);

    while (!q.isEmpty()) {
      V v = q.removeFirst();
      order.add(v);

      for (V nb : adj.get(v)) {
        if (visited.add(nb)) {
          q.addLast(nb);
        }
      }
    }
    return order;
  }

  /**
   * Performs a depth-first traversal from {@code start}.
   *
   * <p>This implementation uses an explicit stack instead of recursion. To
   * preserve the same left-to-right visitation order suggested by the
   * insertion-ordered adjacency sets, neighbors are pushed onto the stack in
   * reverse iteration order.</p>
   *
   * <p>This detail is pedagogically important: a stack reverses processing
   * order, so pushing neighbors in reverse makes the final visitation order
   * match the natural adjacency iteration order students see in the sets.</p>
   *
   * @param start the vertex where the traversal begins
   * @return the DFS visitation order
   * @throws IllegalArgumentException if {@code start} is not in the graph
   *
   * @implNote Time complexity is {@code O(V + E)} over the explored portion of
   *           the graph, and worst-case {@code O(V + E)} when all vertices are
   *           reachable from {@code start}.
   */
  @Override
  public List<V> dfs(V start) {
    requireVertex(start);

    List<V> order = new ArrayList<>();
    Set<V> visited = new HashSet<>();
    Deque<V> stack = new ArrayDeque<>();
    stack.push(start);

    while (!stack.isEmpty()) {
      V v = stack.pop();
      if (!visited.add(v))
        continue;

      order.add(v);

      List<V> nbs = new ArrayList<>(adj.get(v));
      for (int i = nbs.size() - 1; i >= 0; i--) {
        V nb = nbs.get(i);
        if (!visited.contains(nb))
          stack.push(nb);
      }
    }
    return order;
  }

  /**
   * Determines whether at least one path connects {@code from} to {@code to}.
   *
   * <p>The search is performed with breadth-first search. If either endpoint is
   * missing, the method returns {@code false}. If both references denote the
   * same vertex, the method returns {@code true} immediately.</p>
   *
   * <p>Using BFS here is enough because the method only needs to know whether
   * reachability exists, not which route is best. The search stops early as
   * soon as {@code to} is discovered.</p>
   *
   * @param from the source vertex
   * @param to the target vertex
   * @return {@code true} if a path exists; {@code false} otherwise
   *
   * @implNote Worst-case time complexity is {@code O(V + E)}. In practice it
   *           may finish earlier if the destination is found before the full
   *           reachable subgraph is explored.
   */
  @Override
  public boolean hasPath(V from, V to) {
    if (!containsVertex(from) || !containsVertex(to))
      return false;
    if (Objects.equals(from, to))
      return true;

    Set<V> visited = new HashSet<>();
    Deque<V> q = new ArrayDeque<>();
    visited.add(from);
    q.addLast(from);

    while (!q.isEmpty()) {
      V v = q.removeFirst();
      for (V nb : adj.get(v)) {
        if (Objects.equals(nb, to))
          return true;
        if (visited.add(nb))
          q.addLast(nb);
      }
    }
    return false;
  }

  /**
   * Computes a shortest path from {@code from} to {@code to} in an unweighted
   * graph.
   *
   * <p>The method uses breadth-first search and stores parent pointers so the
   * first time {@code to} is discovered, the resulting path has the minimum
   * number of edges. If one of the endpoints does not exist or no path is
   * reachable, the method returns an empty list.</p>
   *
   * <p>This method solves the shortest-path problem only for unweighted graphs.
   * Because every edge has the same cost, BFS guarantees that the first
   * discovered route to {@code to} uses the fewest possible edges.</p>
   *
   * @param from the source vertex
   * @param to the target vertex
   * @return a shortest path from {@code from} to {@code to}, or an empty list
   *         if no path exists
   *
   * @implNote Worst-case time complexity is {@code O(V + E)} for the BFS plus
   *           {@code O(k)} for path reconstruction, where {@code k} is the
   *           number of vertices in the returned path. This remains
   *           {@code O(V + E)} overall.
   */
  @Override
  public List<V> shortestPathUnweighted(V from, V to) {
    if (!containsVertex(from) || !containsVertex(to))
      return List.of();
    if (Objects.equals(from, to))
      return List.of(from);

    Map<V, V> parent = new HashMap<>();
    Set<V> visited = new HashSet<>();
    Deque<V> q = new ArrayDeque<>();

    visited.add(from);
    q.addLast(from);

    while (!q.isEmpty()) {
      V v = q.removeFirst();
      for (V nb : adj.get(v)) {
        if (visited.contains(nb))
          continue;
        visited.add(nb);
        parent.put(nb, v);
        if (Objects.equals(nb, to)) {
          return buildPath(from, to, parent);
        }
        q.addLast(nb);
      }
    }

    return List.of();
  }

  /**
   * Reconstructs a path from {@code from} to {@code to} using the parent map
   * produced by breadth-first search.
   *
   * <p>The path is collected backwards from the destination to the source and
   * then reversed so the result starts at {@code from}. If the reconstruction
   * does not actually reach the source, the method returns an empty list.</p>
   *
   * @param from the source vertex
   * @param to the destination vertex
   * @param parent a map storing the predecessor of each discovered vertex
   * @return the reconstructed path, or an empty list if reconstruction fails
   *
   * @implNote Time complexity is {@code O(k)}, where {@code k} is the number of
   *           vertices placed in the reconstructed path.
   */
  private List<V> buildPath(V from, V to, Map<V, V> parent) {
    List<V> path = new ArrayList<>();
    V cur = to;
    while (cur != null) {
      path.add(cur);
      if (Objects.equals(cur, from))
        break;
      cur = parent.get(cur);
    }
    Collections.reverse(path);
    if (!path.isEmpty() && Objects.equals(path.get(0), from))
      return path;
    return List.of();
  }

  /**
   * Removes all vertices and edges from the graph.
   *
   * <p>After this call, the graph returns to the same logical state as a newly
   * created empty graph with the same directed/undirected configuration.</p>
   *
   * @implNote Time complexity is {@code O(V)} in the size of the adjacency map,
   *           because clearing the map discards all stored vertex-to-neighbor
   *           associations.
   */
  @Override
  public void clear() {
    adj.clear();
    edges = 0;
  }

  /**
   * Validates that {@code v} exists as a vertex of the graph.
   *
   * @param v the vertex to validate
   * @throws IllegalArgumentException if {@code v} is not present in the graph
   *
   * @implNote Average-case time complexity is {@code O(1)} because validation
   *           is a single hash-map membership check.
   */
  private void requireVertex(V v) {
    if (!adj.containsKey(v))
      throw new IllegalArgumentException("Vertex does not exist: " + v);
  }

}
