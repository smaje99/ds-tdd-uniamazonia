package co.edu.udla.ed.api;

import java.util.List;
import java.util.Set;

/**
 * Defines the contract for a graph abstract data type whose vertices store
 * values of type {@code V}. A graph models pairwise relationships between
 * vertices through edges. Depending on the implementation, the graph may be
 * directed, where edges have an orientation, or undirected, where connections
 * are symmetric.
 *
 * <p>
 * This interface focuses on the operations students usually need when
 * studying graphs: adding vertices and edges, querying adjacency, traversing
 * the reachable portion of the graph, checking whether a path exists, and
 * computing shortest paths in the unweighted case.
 * </p>
 *
 * @param <V> the type of value stored in each vertex
 */
public interface Graph<V> {

  /**
   * Indicates whether this graph treats edges as directed.
   *
   * <p>
   * If this method returns {@code true}, an edge from {@code u} to {@code v}
   * does not automatically imply the existence of an edge from {@code v} to
   * {@code u}. If it returns {@code false}, an implementation should treat each
   * connection as bidirectional.
   * </p>
   *
   * @return {@code true} if the graph is directed; {@code false} if it is
   *         undirected
   */
  boolean isDirected();

  /**
   * Adds a vertex to the graph.
   *
   * <p>
   * If the vertex already exists, implementations may ignore the request so
   * that the graph continues to store each logical vertex only once.
   * </p>
   *
   * @param v the vertex value to add
   */
  void addVertex(V v);

  /**
   * Adds an edge from {@code from} to {@code to}.
   *
   * <p>
   * In a directed graph, the edge represents an outgoing connection from
   * {@code from} to {@code to}. In an undirected graph, the same call should
   * create a single bidirectional connection between both vertices.
   * </p>
   *
   * @param from the origin vertex of the edge
   * @param to   the destination vertex of the edge
   */
  void addEdge(V from, V to);

  /**
   * Checks whether the graph currently contains the specified vertex.
   *
   * @param v the vertex value to search for
   * @return {@code true} if the vertex is present; {@code false} otherwise
   */
  boolean containsVertex(V v);

  /**
   * Checks whether the graph currently contains the edge from {@code from} to
   * {@code to}.
   *
   * <p>
   * For directed graphs, the order of the arguments matters. For undirected
   * graphs, implementations should treat the connection symmetrically.
   * </p>
   *
   * @param from the origin vertex of the edge
   * @param to   the destination vertex of the edge
   * @return {@code true} if the edge exists; {@code false} otherwise
   */
  boolean containsEdge(V from, V to);

  /**
   * Returns the set of all vertices currently stored in the graph.
   *
   * @return a set containing every vertex in the graph
   */
  Set<V> vertices();

  /**
   * Returns the vertices adjacent to {@code v}.
   *
   * <p>
   * In a directed graph, these neighbors are usually the vertices reachable
   * through outgoing edges from {@code v}. In an undirected graph, they are the
   * vertices directly connected to {@code v}.
   * </p>
   *
   * @param v the vertex whose adjacency set is requested
   * @return the set of vertices adjacent to {@code v}
   */
  Set<V> neighbors(V v);

  /**
   * Returns the number of vertices currently stored in the graph.
   *
   * @return the number of vertices
   */
  int vertexCount();

  /**
   * Returns the number of logical edges currently stored in the graph.
   *
   * <p>
   * In an undirected graph, a bidirectional connection should count as one
   * edge rather than two separate directed arcs.
   * </p>
   *
   * @return the number of edges
   */
  int edgeCount();

  /**
   * Performs a breadth-first search starting at {@code start}.
   *
   * <p>
   * The returned list records vertices in the order in which the traversal
   * visits them. Breadth-first search explores the graph level by level, so it
   * reaches all vertices at distance {@code 1} from the start before moving to
   * vertices at distance {@code 2}, and so on.
   * </p>
   *
   * @param start the vertex where the traversal begins
   * @return a list with the BFS visitation order starting at {@code start}
   */
  List<V> bfs(V start);

  /**
   * Performs a depth-first search starting at {@code start}.
   *
   * <p>
   * The returned list records vertices in the order in which the traversal
   * visits them. Depth-first search follows one path as far as possible before
   * backtracking to explore alternative branches.
   * </p>
   *
   * @param start the vertex where the traversal begins
   * @return a list with the DFS visitation order starting at {@code start}
   */
  List<V> dfs(V start);

  /**
   * Determines whether there is at least one path from {@code from} to
   * {@code to}.
   *
   * <p>
   * For directed graphs, the path must follow edge orientation. For
   * undirected graphs, any chain of adjacent vertices connecting both endpoints
   * is valid.
   * </p>
   *
   * @param from the source vertex
   * @param to   the target vertex
   * @return {@code true} if a path exists from {@code from} to {@code to};
   *         {@code false} otherwise
   */
  boolean hasPath(V from, V to);

  /**
   * Computes a shortest path between {@code from} and {@code to} in an
   * unweighted graph.
   *
   * <p>
   * This operation is typically implemented with breadth-first search, which
   * guarantees a path with the minimum number of edges when all edges have the
   * same cost. The returned list usually includes both endpoints. If no path
   * exists, the method returns an empty list.
   * </p>
   *
   * @param from the source vertex
   * @param to   the target vertex
   * @return a shortest path from {@code from} to {@code to}, or an empty list
   *         if no path exists
   */
  List<V> shortestPathUnweighted(V from, V to);

  /**
   * Removes all vertices and edges from the graph, returning it to the empty
   * state.
   */
  void clear();

}
