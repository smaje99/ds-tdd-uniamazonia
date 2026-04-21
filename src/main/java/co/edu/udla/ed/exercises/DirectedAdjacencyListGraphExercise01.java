package co.edu.udla.ed.exercises;

import java.util.LinkedHashSet;
import java.util.Map;

import co.edu.udla.ed.impl.scratch.AdjacencyListGraph;

/**
 * Exercise 01 for the Directed Adjacency-List Graph series.
 *
 * <p><strong>Student task:</strong> Build a small directed graph and report the number of vertices and edges together
 * with one asymmetric edge check.</p>
 */
public final class DirectedAdjacencyListGraphExercise01 {

  public String solveWithCustomIterator(AdjacencyListGraph<String> graph) {
    graph.addEdge("A", "B");
    graph.addEdge("A", "C");
    graph.addEdge("B", "D");
    graph.addEdge("C", "D");
    return ExerciseSupport.format(
        ExerciseSupport.named("vertices", ExerciseSupport.countWithIterator(graph.verticesIterable())),
        ExerciseSupport.named("edges", graph.edgeCount()),
        ExerciseSupport.named("BtoA", graph.containsEdge("B", "A")));
  }

  public String solveWithJavaLoops(Map<String, LinkedHashSet<String>> graph) {
    ExerciseSupport.directedGraphAddEdge(graph, "A", "B");
    ExerciseSupport.directedGraphAddEdge(graph, "A", "C");
    ExerciseSupport.directedGraphAddEdge(graph, "B", "D");
    ExerciseSupport.directedGraphAddEdge(graph, "C", "D");
    return ExerciseSupport.format(
        ExerciseSupport.named("vertices", graph.size()),
        ExerciseSupport.named("edges", ExerciseSupport.directedGraphEdgeCount(graph)),
        ExerciseSupport.named("BtoA", graph.get("B").contains("A")));
  }

  public String solveWithStreams(Map<String, LinkedHashSet<String>> graph) {
    ExerciseSupport.directedGraphAddEdge(graph, "A", "B");
    ExerciseSupport.directedGraphAddEdge(graph, "A", "C");
    ExerciseSupport.directedGraphAddEdge(graph, "B", "D");
    ExerciseSupport.directedGraphAddEdge(graph, "C", "D");
    return ExerciseSupport.format(
        ExerciseSupport.named("vertices", graph.keySet().stream().count()),
        ExerciseSupport.named("edges", ExerciseSupport.directedGraphEdgeCount(graph)),
        ExerciseSupport.named("BtoA", graph.get("B").contains("A")));
  }

}
