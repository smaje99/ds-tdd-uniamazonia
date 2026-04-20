package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

final class ExerciseSupport {

  private ExerciseSupport() {
  }

  /**
   * Copies any iterable sequence into a regular Java list.
   *
   * <p>
   * The exercise package uses this helper to normalize snapshots coming from
   * custom ADTs and the JDK-backed implementations into the same textual form.
   * </p>
   *
   * @param values values to copy in iteration order
   * @param <T>    element type
   * @return a mutable Java list with the same logical order
   */
  static <T> java.util.List<T> toJavaList(Iterable<T> values) {
    java.util.List<T> copy = new ArrayList<>();
    for (T value : values) {
      copy.add(value);
    }
    return copy;
  }

  static <T> String snapshot(Iterable<T> values) {
    return toJavaList(values).toString();
  }

  static <T> String snapshotWithIterator(Iterable<T> values) {
    return snapshot(values);
  }

  static <T> String snapshotWithLoop(java.util.List<T> values) {
    java.util.List<T> copy = new ArrayList<>();
    for (int i = 0; i < values.size(); i++) {
      copy.add(values.get(i));
    }
    return copy.toString();
  }

  static <T> String snapshotCollectionWithLoop(Collection<T> values) {
    java.util.List<T> copy = new ArrayList<>();
    for (T value : values) {
      copy.add(value);
    }
    return copy.toString();
  }

  static <T> String snapshotWithStreams(Collection<T> values) {
    return values.stream().map(String::valueOf).collect(Collectors.joining(", ", "[", "]"));
  }

  static <T> String snapshotIterableWithStreams(Iterable<T> values) {
    return StreamSupport.stream(values.spliterator(), false)
        .map(String::valueOf)
        .collect(Collectors.joining(", ", "[", "]"));
  }

  static <T> int countWithIterator(Iterable<T> values) {
    int count = 0;
    for (var _ : values) {
      count++;
    }
    return count;
  }

  static <T> String dequeSnapshotWithLoop(Deque<T> values) {
    java.util.List<T> copy = new ArrayList<>();
    for (T value : values) {
      copy.add(value);
    }
    return copy.toString();
  }

  static <T> String dequeSnapshotWithStreams(Deque<T> values) {
    return values.stream().map(String::valueOf).collect(Collectors.joining(", ", "[", "]"));
  }

  static <T> String drainDequeWithLoop(ArrayDeque<T> deque) {
    java.util.List<T> values = new ArrayList<>();
    while (!deque.isEmpty()) {
      values.add(deque.removeFirst());
    }
    return values.toString();
  }

  static <T> String stackDrainWithLoop(ArrayDeque<T> deque) {
    java.util.List<T> values = new ArrayList<>();
    while (!deque.isEmpty()) {
      values.add(deque.removeLast());
    }
    return values.toString();
  }

  static <T> String stackDrainWithStreams(ArrayDeque<T> deque) {
    LinkedList<T> values = new LinkedList<>(deque);
    return values.reversed().stream().map(String::valueOf).collect(Collectors.joining(", ", "[", "]"));
  }

  static <T> void treeMakeRoot(ArrayList<T> values, T rootValue) {
    values.clear();
    values.add(rootValue);
  }

  static <T> int treeAttachLeft(ArrayList<T> values, int parentIndex, T value) {
    return treeAttach(values, parentIndex * 2 + 1, value);
  }

  static <T> int treeAttachRight(ArrayList<T> values, int parentIndex, T value) {
    return treeAttach(values, parentIndex * 2 + 2, value);
  }

  static <T> int treeHeight(ArrayList<T> values) {
    return treeHeight(values, 0);
  }

  static <T> java.util.List<T> treePreOrder(ArrayList<T> values) {
    java.util.List<T> out = new ArrayList<>();
    treePreOrder(values, 0, out);
    return out;
  }

  static <T> java.util.List<T> treeInOrder(ArrayList<T> values) {
    java.util.List<T> out = new ArrayList<>();
    treeInOrder(values, 0, out);
    return out;
  }

  static <T> java.util.List<T> treePostOrder(ArrayList<T> values) {
    java.util.List<T> out = new ArrayList<>();
    treePostOrder(values, 0, out);
    return out;
  }

  static <T> java.util.List<T> treeLevelOrder(ArrayList<T> values) {
    java.util.List<T> out = new ArrayList<>();
    for (T value : values) {
      if (value != null) {
        out.add(value);
      }
    }
    return out;
  }

  static <T extends Comparable<T>> int avlHeightFromValues(TreeSet<T> values) {
    int size = values.size();
    if (size == 0) {
      return 0;
    }
    int height = 0;
    int capacity = 0;
    while (capacity < size) {
      height++;
      capacity = (1 << height) - 1;
    }
    return height;
  }

  static <V> void graphAddEdge(Map<V, LinkedHashSet<V>> graph, V from, V to) {
    graph.computeIfAbsent(from, ignored -> new LinkedHashSet<>());
    graph.computeIfAbsent(to, ignored -> new LinkedHashSet<>());
    graph.get(from).add(to);
    graph.get(to).add(from);
  }

  static <V> int graphEdgeCount(Map<V, LinkedHashSet<V>> graph) {
    int adjacencyCount = 0;
    for (Set<V> neighbors : graph.values()) {
      adjacencyCount += neighbors.size();
    }
    return adjacencyCount / 2;
  }

  static <V> java.util.List<V> graphBfs(Map<V, LinkedHashSet<V>> graph, V start) {
    requireGraphVertex(graph, start);
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

  static <V> java.util.List<V> graphDfs(Map<V, LinkedHashSet<V>> graph, V start) {
    requireGraphVertex(graph, start);
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

  static <V> boolean graphHasPath(Map<V, LinkedHashSet<V>> graph, V from, V to) {
    if (!graph.containsKey(from) || !graph.containsKey(to)) {
      return false;
    }
    return !graphShortestPath(graph, from, to).isEmpty();
  }

  static <V> java.util.List<V> graphShortestPath(Map<V, LinkedHashSet<V>> graph, V from, V to) {
    if (!graph.containsKey(from) || !graph.containsKey(to)) {
      return java.util.List.of();
    }
    if (Objects.equals(from, to)) {
      return java.util.List.of(from);
    }

    ArrayDeque<V> queue = new ArrayDeque<>();
    Map<V, V> previous = new HashMap<>();
    Set<V> visited = new HashSet<>();
    queue.addLast(from);
    visited.add(from);

    while (!queue.isEmpty()) {
      V vertex = queue.removeFirst();
      for (V neighbor : graph.get(vertex)) {
        if (!visited.add(neighbor)) {
          continue;
        }
        previous.put(neighbor, vertex);
        if (Objects.equals(neighbor, to)) {
          return rebuildPath(previous, from, to);
        }
        queue.addLast(neighbor);
      }
    }
    return java.util.List.of();
  }

  private static <T> int treeAttach(ArrayList<T> values, int index, T value) {
    ensureTreeCapacity(values, index);
    if (values.get(index) != null) {
      throw new IllegalStateException("child already exists");
    }
    values.set(index, value);
    return index;
  }

  private static <T> void ensureTreeCapacity(ArrayList<T> values, int index) {
    while (values.size() <= index) {
      values.add(null);
    }
  }

  private static <T> int treeHeight(ArrayList<T> values, int index) {
    if (index >= values.size() || values.get(index) == null) {
      return 0;
    }
    return 1 + Math.max(treeHeight(values, index * 2 + 1), treeHeight(values, index * 2 + 2));
  }

  private static <T> void treePreOrder(ArrayList<T> values, int index, java.util.List<T> out) {
    if (index >= values.size()) {
      return;
    }
    T value = values.get(index);
    if (value == null) {
      return;
    }
    out.add(value);
    treePreOrder(values, index * 2 + 1, out);
    treePreOrder(values, index * 2 + 2, out);
  }

  private static <T> void treeInOrder(ArrayList<T> values, int index, java.util.List<T> out) {
    if (index >= values.size()) {
      return;
    }
    T value = values.get(index);
    if (value == null) {
      return;
    }
    treeInOrder(values, index * 2 + 1, out);
    out.add(value);
    treeInOrder(values, index * 2 + 2, out);
  }

  private static <T> void treePostOrder(ArrayList<T> values, int index, java.util.List<T> out) {
    if (index >= values.size()) {
      return;
    }
    T value = values.get(index);
    if (value == null) {
      return;
    }
    treePostOrder(values, index * 2 + 1, out);
    treePostOrder(values, index * 2 + 2, out);
    out.add(value);
  }

  private static <V> void requireGraphVertex(Map<V, LinkedHashSet<V>> graph, V start) {
    if (!graph.containsKey(start)) {
      throw new IllegalArgumentException("Vertex does not exist: " + start);
    }
  }

  private static <V> java.util.List<V> rebuildPath(Map<V, V> previous, V from, V to) {
    LinkedList<V> path = new LinkedList<>();
    V current = to;
    while (current != null) {
      path.addFirst(current);
      if (Objects.equals(current, from)) {
        return path;
      }
      current = previous.get(current);
    }
    return java.util.List.of();
  }

  /**
   * Joins feedback fragments with the package-wide separator.
   *
   * @param parts named fragments such as {@code size=3} or {@code inOrder=[...]}
   * @return a single feedback string ready for tests
   */
  static String format(String... parts) {
    return String.join("|", parts);
  }

  static String named(String name, Object value) {
    return name + "=" + value;
  }

  /**
   * Factory for the identity-based learner object used in non-ordered exercises.
   *
   * @param name learner display name
   * @param code learner identifier used in equality checks
   * @return a learner value object
   */
  static Learner learner(String name, int code) {
    return new Learner(name, code);
  }

  static RankedLearner rankedLearner(String name, int level) {
    return new RankedLearner(name, level);
  }

  /**
   * Factory for the custom hash-table key used in the domain-based hash exercise.
   *
   * @param course  course code
   * @param section section identifier
   * @return a key object with readable text and explicit equality semantics
   */
  static EnrollmentKey enrollmentKey(String course, String section) {
    return new EnrollmentKey(course, section);
  }

  /**
   * Identity/value object used by list, stack, queue, binary-tree, and graph
   * exercises.
   *
   * <p>
   * Two learners are equal when both their display name and numeric code match.
   * The string form is intentionally compact so test feedback remains easy to
   * read.
   * </p>
   */
  static final class Learner {
    private final String name;
    private final int code;

    Learner(String name, int code) {
      this.name = name;
      this.code = code;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (!(obj instanceof Learner other)) {
        return false;
      }
      return code == other.code && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, code);
    }

    @Override
    public String toString() {
      return name + "#" + code;
    }
  }

  /**
   * Comparable domain object used by BST and AVL exercises.
   *
   * <p>
   * Ordering is primarily determined by {@code level}; ties break by name so
   * {@code inOrder()} remains deterministic and readable in test feedback.
   * </p>
   */
  static final class RankedLearner implements Comparable<RankedLearner> {
    private final String name;
    private final int level;

    RankedLearner(String name, int level) {
      this.name = name;
      this.level = level;
    }

    @Override
    public int compareTo(RankedLearner other) {
      int byLevel = Integer.compare(level, other.level);
      if (byLevel != 0) {
        return byLevel;
      }
      return name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (!(obj instanceof RankedLearner other)) {
        return false;
      }
      return level == other.level && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, level);
    }

    @Override
    public String toString() {
      return name + "@" + level;
    }
  }

  /**
   * Custom hash-table key used to teach lookup and update semantics with domain
   * objects.
   *
   * <p>
   * The constant hash code forces collisions on purpose so the exercise can still
   * validate logical correctness when several distinct keys share the same
   * bucket.
   * </p>
   */
  static final class EnrollmentKey {
    private final String course;
    private final String section;

    EnrollmentKey(String course, String section) {
      this.course = course;
      this.section = section;
    }

    @Override
    public int hashCode() {
      return 17;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (!(obj instanceof EnrollmentKey other)) {
        return false;
      }
      return Objects.equals(course, other.course) && Objects.equals(section, other.section);
    }

    @Override
    public String toString() {
      return course + "-" + section;
    }
  }

  /**
   * Collision-heavy helper key used by the resizing and collision exercise in the
   * hash-table series.
   */
  static final class BadHashKey {
    private final String id;

    BadHashKey(String id) {
      this.id = id;
    }

    @Override
    public int hashCode() {
      return 1;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (!(obj instanceof BadHashKey other)) {
        return false;
      }
      return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
      return id;
    }
  }

}
