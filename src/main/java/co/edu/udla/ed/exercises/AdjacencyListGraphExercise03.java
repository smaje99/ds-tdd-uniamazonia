package co.edu.udla.ed.exercises;

import java.util.LinkedHashSet;
import java.util.Map;

import co.edu.udla.ed.impl.scratch.AdjacencyListGraph;

/**
 * Exercise 03 for the Adjacency-List Graph series.
 *
 * <p><strong>Student task:</strong> Create the graph and compare DFS order, path existence, and the shortest unweighted path.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class AdjacencyListGraphExercise03 {

  /**
   * Solves Exercise 03 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(AdjacencyListGraph<String> graph) {
    buildSampleGraph(graph);
    return ExerciseSupport.format(
        ExerciseSupport.named("dfs", ExerciseSupport.snapshotWithIterator(graph.dfsIterable("A"))),
        ExerciseSupport.named("hasPathAtoE", graph.hasPath("A", "E")),
        ExerciseSupport.named("shortest", ExerciseSupport.snapshot(graph.shortestPathUnweighted("A", "E"))));
  }

  /**
   * Solves Exercise 03 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(Map<String, LinkedHashSet<String>> graph) {
    buildSampleGraph(graph);
    return ExerciseSupport.format(
        ExerciseSupport.named("dfs", ExerciseSupport.snapshotWithLoop(ExerciseSupport.graphDfs(graph, "A"))),
        ExerciseSupport.named("hasPathAtoE", ExerciseSupport.graphHasPath(graph, "A", "E")),
        ExerciseSupport.named("shortest", ExerciseSupport.snapshotWithLoop(ExerciseSupport.graphShortestPath(graph, "A", "E"))));
  }

  /**
   * Solves Exercise 03 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(Map<String, LinkedHashSet<String>> graph) {
    buildSampleGraph(graph);
    return ExerciseSupport.format(
        ExerciseSupport.named("dfs", ExerciseSupport.snapshotWithStreams(ExerciseSupport.graphDfs(graph, "A"))),
        ExerciseSupport.named("hasPathAtoE", ExerciseSupport.graphHasPath(graph, "A", "E")),
        ExerciseSupport.named("shortest", ExerciseSupport.snapshotWithStreams(ExerciseSupport.graphShortestPath(graph, "A", "E"))));
  }

  private void buildSampleGraph(AdjacencyListGraph<String> graph) {
    graph.addEdge("A", "B");
    graph.addEdge("A", "C");
    graph.addEdge("B", "D");
    graph.addEdge("C", "D");
    graph.addEdge("D", "E");
  }

  private void buildSampleGraph(Map<String, LinkedHashSet<String>> graph) {
    ExerciseSupport.graphAddEdge(graph, "A", "B");
    ExerciseSupport.graphAddEdge(graph, "A", "C");
    ExerciseSupport.graphAddEdge(graph, "B", "D");
    ExerciseSupport.graphAddEdge(graph, "C", "D");
    ExerciseSupport.graphAddEdge(graph, "D", "E");
  }

}
