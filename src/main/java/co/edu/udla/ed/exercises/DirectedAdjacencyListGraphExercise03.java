package co.edu.udla.ed.exercises;

import java.util.LinkedHashSet;
import java.util.Map;

import co.edu.udla.ed.impl.scratch.AdjacencyListGraph;

/**
 * Exercise 03 for the Directed Adjacency-List Graph series.
 *
 * <p><strong>Student task:</strong> Compute a shortest unweighted path that respects edge direction.</p>
 */
public final class DirectedAdjacencyListGraphExercise03 {

  public String solveWithCustomIterator(AdjacencyListGraph<String> graph) {
    graph.addEdge("A", "B");
    graph.addEdge("A", "C");
    graph.addEdge("B", "D");
    graph.addEdge("C", "D");
    graph.addEdge("D", "E");
    return ExerciseSupport.snapshot(graph.shortestPathUnweighted("A", "E"));
  }

  public String solveWithJavaLoops(Map<String, LinkedHashSet<String>> graph) {
    ExerciseSupport.directedGraphAddEdge(graph, "A", "B");
    ExerciseSupport.directedGraphAddEdge(graph, "A", "C");
    ExerciseSupport.directedGraphAddEdge(graph, "B", "D");
    ExerciseSupport.directedGraphAddEdge(graph, "C", "D");
    ExerciseSupport.directedGraphAddEdge(graph, "D", "E");
    return ExerciseSupport.snapshot(ExerciseSupport.graphShortestPath(graph, "A", "E"));
  }

  public String solveWithStreams(Map<String, LinkedHashSet<String>> graph) {
    ExerciseSupport.directedGraphAddEdge(graph, "A", "B");
    ExerciseSupport.directedGraphAddEdge(graph, "A", "C");
    ExerciseSupport.directedGraphAddEdge(graph, "B", "D");
    ExerciseSupport.directedGraphAddEdge(graph, "C", "D");
    ExerciseSupport.directedGraphAddEdge(graph, "D", "E");
    return ExerciseSupport.snapshotIterableWithStreams(ExerciseSupport.graphShortestPath(graph, "A", "E"));
  }

}
