package co.edu.udla.ed.common;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

import co.edu.udla.ed.api.GraphSearchResult;
import co.edu.udla.ed.api.KeyValueSearchResult;
import co.edu.udla.ed.api.LinearSearchResult;
import co.edu.udla.ed.api.TreeSearchResult;
import co.edu.udla.ed.impl.scratch.search.BinarySearch;
import co.edu.udla.ed.impl.scratch.search.JumpSearch;
import co.edu.udla.ed.impl.scratch.search.LinearSearch;
import co.edu.udla.ed.impl.scratch.search.OrderedTreeSearch;
import co.edu.udla.ed.impl.scratch.sorting.JavaListSequenceAdapter;

/**
 * Utility methods that reuse repository search algorithms with JDK
 * collections.
 *
 * <p>The adapters preserve the same result objects used by the scratch data
 * structures while letting exercises compare custom implementations with JDK
 * equivalents. Methods that search ordered inputs assume the caller already
 * supplied data in the required order.</p>
 */
public final class JavaSearchAdapters {

  private JavaSearchAdapters() {
  }

  /**
   * Performs a linear search over an {@link ArrayList}.
   *
   * @param values sequence to scan from index {@code 0} to {@code size - 1}
   * @param target value to find using {@link java.util.Objects#equals(Object, Object)}
   * @param <T> element type
   * @return the first matching index and value, or {@code notFound()}
   */
  public static <T> LinearSearchResult<T> linearSearch(ArrayList<T> values, T target) {
    return new LinearSearch<T>().search(new JavaListSequenceAdapter<>(values), target);
  }

  /**
   * Performs a linear search over a {@link LinkedList}.
   *
   * @param values sequence to scan from index {@code 0} to {@code size - 1}
   * @param target value to find using {@link java.util.Objects#equals(Object, Object)}
   * @param <T> element type
   * @return the first matching index and value, or {@code notFound()}
   */
  public static <T> LinearSearchResult<T> linearSearch(LinkedList<T> values, T target) {
    return new LinearSearch<T>().search(new JavaListSequenceAdapter<>(values), target);
  }

  public static <T> LinearSearchResult<T> binarySearch(ArrayList<T> values, T target,
      Comparator<? super T> comparator) {
    return new BinarySearch<T>().search(new JavaListSequenceAdapter<>(values), target, comparator);
  }

  public static <T> LinearSearchResult<T> jumpSearch(ArrayList<T> values, T target,
      Comparator<? super T> comparator) {
    return new JumpSearch<T>().search(new JavaListSequenceAdapter<>(values), target, comparator);
  }

  /**
   * Searches for a key in a {@link LinkedHashMap}.
   *
   * @param map map to inspect
   * @param key key to locate
   * @param <K> key type
   * @param <V> value type
   * @return a key-value result whose {@code found} flag follows
   *         {@link LinkedHashMap#containsKey(Object)}
   */
  public static <K, V> KeyValueSearchResult<K, V> keyValueSearch(LinkedHashMap<K, V> map, K key) {
    return new KeyValueSearchResult<>(map.containsKey(key), key, map.get(key));
  }

  /**
   * Searches an ordered {@link TreeSet} and reports the visited sorted prefix.
   *
   * @param tree ordered values to scan in ascending order
   * @param target value to locate
   * @param <T> comparable element type
   * @return a tree-search result with the target and the observed visit order
   */
  public static <T extends Comparable<T>> TreeSearchResult<T> orderedTreeSearch(TreeSet<T> tree, T target) {
    return new OrderedTreeSearch<T>().search(tree, target);
  }

  /**
   * Performs breadth-first search over an adjacency-list map.
   *
   * @param graph map from each vertex to its neighbors in deterministic order
   * @param start source vertex
   * @param target target vertex
   * @param <V> vertex type
   * @return visited vertices and, when reachable, a shortest unweighted path
   */
  public static <V> GraphSearchResult<V> breadthFirstSearch(Map<V, LinkedHashSet<V>> graph, V start, V target) {
    java.util.List<V> visited = bfs(graph, start);
    java.util.List<V> path = visited.contains(target) ? shortestPath(graph, start, target) : java.util.List.of();
    return new GraphSearchResult<>(visited.contains(target), visited, path);
  }

  /**
   * Performs depth-first search over an adjacency-list map.
   *
   * @param graph map from each vertex to its neighbors in deterministic order
   * @param start source vertex
   * @param target target vertex
   * @param <V> vertex type
   * @return visited vertices and, when reachable, a shortest unweighted path
   */
  public static <V> GraphSearchResult<V> depthFirstSearch(Map<V, LinkedHashSet<V>> graph, V start, V target) {
    java.util.List<V> visited = dfs(graph, start);
    java.util.List<V> path = visited.contains(target) ? shortestPath(graph, start, target) : java.util.List.of();
    return new GraphSearchResult<>(visited.contains(target), visited, path);
  }

  /**
   * Finds a minimum-edge path in an unweighted adjacency-list map.
   *
   * @param graph map from each vertex to its neighbors in deterministic order
   * @param start source vertex
   * @param target target vertex
   * @param <V> vertex type
   * @return a graph-search result whose path is empty when no route exists
   */
  public static <V> GraphSearchResult<V> shortestPathSearch(Map<V, LinkedHashSet<V>> graph, V start, V target) {
    java.util.List<V> path = shortestPath(graph, start, target);
    return new GraphSearchResult<>(!path.isEmpty(), bfs(graph, start), path);
  }

  public static <V> GraphSearchResult<V> weightedShortestPathSearch(Map<V, LinkedHashMap<V, Double>> graph, V start,
      V target) {
    java.util.List<V> path = weightedShortestPath(graph, start, target);
    return new GraphSearchResult<>(!path.isEmpty(), new ArrayList<>(weightedDistances(graph, start).keySet()), path);
  }

  private static <V> java.util.List<V> bfs(Map<V, LinkedHashSet<V>> graph, V start) {
    requireVertex(graph, start);
    java.util.List<V> order = new ArrayList<>();
    Set<V> visited = new HashSet<>();
    ArrayDeque<V> queue = new ArrayDeque<>();
    visited.add(start);
    queue.addLast(start);
    while (!queue.isEmpty()) {
      V vertex = queue.removeFirst();
      order.add(vertex);
      for (V neighbor : graph.get(vertex)) {
        if (visited.add(neighbor)) {
          queue.addLast(neighbor);
        }
      }
    }
    return order;
  }

  private static <V> java.util.List<V> dfs(Map<V, LinkedHashSet<V>> graph, V start) {
    requireVertex(graph, start);
    java.util.List<V> order = new ArrayList<>();
    Set<V> visited = new HashSet<>();
    ArrayDeque<V> stack = new ArrayDeque<>();
    stack.push(start);
    while (!stack.isEmpty()) {
      V vertex = stack.pop();
      if (!visited.add(vertex)) {
        continue;
      }
      order.add(vertex);
      java.util.List<V> neighbors = new ArrayList<>(graph.get(vertex));
      for (int i = neighbors.size() - 1; i >= 0; i--) {
        V neighbor = neighbors.get(i);
        if (!visited.contains(neighbor)) {
          stack.push(neighbor);
        }
      }
    }
    return order;
  }

  private static <V> java.util.List<V> shortestPath(Map<V, LinkedHashSet<V>> graph, V start, V target) {
    if (!graph.containsKey(start) || !graph.containsKey(target)) {
      return java.util.List.of();
    }
    if (Objects.equals(start, target)) {
      return java.util.List.of(start);
    }
    ArrayDeque<V> queue = new ArrayDeque<>();
    Map<V, V> previous = new HashMap<>();
    Set<V> visited = new HashSet<>();
    queue.addLast(start);
    visited.add(start);
    while (!queue.isEmpty()) {
      V vertex = queue.removeFirst();
      for (V neighbor : graph.get(vertex)) {
        if (!visited.add(neighbor)) {
          continue;
        }
        previous.put(neighbor, vertex);
        if (Objects.equals(neighbor, target)) {
          return rebuildPath(previous, start, target);
        }
        queue.addLast(neighbor);
      }
    }
    return java.util.List.of();
  }

  private static <V> LinkedHashMap<V, Double> weightedDistances(Map<V, LinkedHashMap<V, Double>> graph, V start) {
    if (!graph.containsKey(start)) {
      throw new IllegalArgumentException("Vertex does not exist: " + start);
    }
    LinkedHashMap<V, Double> distances = new LinkedHashMap<>();
    for (V vertex : graph.keySet()) {
      distances.put(vertex, Double.POSITIVE_INFINITY);
    }
    distances.put(start, 0.0);
    PriorityQueue<WeightedStep<V>> queue = new PriorityQueue<>();
    queue.add(new WeightedStep<>(start, 0.0));
    while (!queue.isEmpty()) {
      WeightedStep<V> current = queue.remove();
      if (current.distance > distances.get(current.vertex)) {
        continue;
      }
      for (Map.Entry<V, Double> edge : graph.get(current.vertex).entrySet()) {
        double candidate = current.distance + edge.getValue();
        if (candidate < distances.get(edge.getKey())) {
          distances.put(edge.getKey(), candidate);
          queue.add(new WeightedStep<>(edge.getKey(), candidate));
        }
      }
    }
    return distances;
  }

  private static <V> java.util.List<V> weightedShortestPath(Map<V, LinkedHashMap<V, Double>> graph, V start, V target) {
    if (!graph.containsKey(start) || !graph.containsKey(target)) {
      return java.util.List.of();
    }
    LinkedHashMap<V, Double> distances = new LinkedHashMap<>();
    LinkedHashMap<V, V> previous = new LinkedHashMap<>();
    for (V vertex : graph.keySet()) {
      distances.put(vertex, Double.POSITIVE_INFINITY);
    }
    distances.put(start, 0.0);
    PriorityQueue<WeightedStep<V>> queue = new PriorityQueue<>();
    queue.add(new WeightedStep<>(start, 0.0));
    while (!queue.isEmpty()) {
      WeightedStep<V> current = queue.remove();
      if (Objects.equals(current.vertex, target)) {
        break;
      }
      if (current.distance > distances.get(current.vertex)) {
        continue;
      }
      for (Map.Entry<V, Double> edge : graph.get(current.vertex).entrySet()) {
        double candidate = current.distance + edge.getValue();
        if (candidate < distances.get(edge.getKey())) {
          distances.put(edge.getKey(), candidate);
          previous.put(edge.getKey(), current.vertex);
          queue.add(new WeightedStep<>(edge.getKey(), candidate));
        }
      }
    }
    if (Double.isInfinite(distances.get(target))) {
      return java.util.List.of();
    }
    return rebuildPath(previous, start, target);
  }

  private static <V> java.util.List<V> rebuildPath(Map<V, V> previous, V start, V target) {
    LinkedList<V> path = new LinkedList<>();
    V current = target;
    while (current != null) {
      path.addFirst(current);
      if (Objects.equals(current, start)) {
        return path;
      }
      current = previous.get(current);
    }
    return java.util.List.of();
  }

  private static <V> void requireVertex(Map<V, LinkedHashSet<V>> graph, V start) {
    if (!graph.containsKey(start)) {
      throw new IllegalArgumentException("Vertex does not exist: " + start);
    }
  }

  private static final class WeightedStep<V> implements Comparable<WeightedStep<V>> {
    private final V vertex;
    private final double distance;

    private WeightedStep(V vertex, double distance) {
      this.vertex = vertex;
      this.distance = distance;
    }

    @Override
    public int compareTo(WeightedStep<V> other) {
      int byDistance = Double.compare(distance, other.distance);
      if (byDistance != 0) {
        return byDistance;
      }
      return String.valueOf(vertex).compareTo(String.valueOf(other.vertex));
    }
  }

}
