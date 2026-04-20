package co.edu.udla.ed.exercises;

import java.util.LinkedHashSet;
import java.util.Map;

import co.edu.udla.ed.impl.scratch.AdjacencyListGraph;

/**
 * Exercise 01 for the Adjacency-List Graph series.
 *
 * <p><strong>Student task:</strong> Create the graph and report vertex count, edge count, and the deterministic neighbor snapshots of key vertices.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class AdjacencyListGraphExercise01 {

  /**
   * Solves Exercise 01 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(AdjacencyListGraph<String> graph) {
    buildSampleGraph(graph);
    return ExerciseSupport.format(
        ExerciseSupport.named("vertices", ExerciseSupport.countWithIterator(graph.verticesIterable())),
        ExerciseSupport.named("edges", graph.edgeCount()),
        ExerciseSupport.named("neighborsA", ExerciseSupport.snapshotWithIterator(graph.neighborsIterable("A"))),
        ExerciseSupport.named("neighborsD", ExerciseSupport.snapshotWithIterator(graph.neighborsIterable("D"))));
  }

  /**
   * Solves Exercise 01 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(Map<String, LinkedHashSet<String>> graph) {
    buildSampleGraph(graph);
    return ExerciseSupport.format(
        ExerciseSupport.named("vertices", graph.size()),
        ExerciseSupport.named("edges", ExerciseSupport.graphEdgeCount(graph)),
        ExerciseSupport.named("neighborsA", ExerciseSupport.snapshotCollectionWithLoop(graph.get("A"))),
        ExerciseSupport.named("neighborsD", ExerciseSupport.snapshotCollectionWithLoop(graph.get("D"))));
  }

  /**
   * Solves Exercise 01 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(Map<String, LinkedHashSet<String>> graph) {
    buildSampleGraph(graph);
    return ExerciseSupport.format(
        ExerciseSupport.named("vertices", graph.keySet().stream().count()),
        ExerciseSupport.named("edges", ExerciseSupport.graphEdgeCount(graph)),
        ExerciseSupport.named("neighborsA", ExerciseSupport.snapshotWithStreams(graph.get("A"))),
        ExerciseSupport.named("neighborsD", ExerciseSupport.snapshotWithStreams(graph.get("D"))));
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
