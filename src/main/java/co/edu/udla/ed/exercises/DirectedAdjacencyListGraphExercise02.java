package co.edu.udla.ed.exercises;

import java.util.LinkedHashSet;
import java.util.Map;

import co.edu.udla.ed.impl.scratch.AdjacencyListGraph;

/**
 * Exercise 02 for the Directed Adjacency-List Graph series.
 *
 * <p><strong>Student task:</strong> Traverse a directed graph with breadth-first search starting at a source
 * vertex.</p>
 */
public final class DirectedAdjacencyListGraphExercise02 {

  public String solveWithCustomIterator(AdjacencyListGraph<String> graph) {
    graph.addEdge("A", "B");
    graph.addEdge("A", "C");
    graph.addEdge("B", "D");
    graph.addEdge("C", "D");
    return ExerciseSupport.snapshot(graph.bfsIterable("A"));
  }

  public String solveWithJavaLoops(Map<String, LinkedHashSet<String>> graph) {
    ExerciseSupport.directedGraphAddEdge(graph, "A", "B");
    ExerciseSupport.directedGraphAddEdge(graph, "A", "C");
    ExerciseSupport.directedGraphAddEdge(graph, "B", "D");
    ExerciseSupport.directedGraphAddEdge(graph, "C", "D");
    return ExerciseSupport.snapshot(ExerciseSupport.graphBfs(graph, "A"));
  }

  public String solveWithStreams(Map<String, LinkedHashSet<String>> graph) {
    ExerciseSupport.directedGraphAddEdge(graph, "A", "B");
    ExerciseSupport.directedGraphAddEdge(graph, "A", "C");
    ExerciseSupport.directedGraphAddEdge(graph, "B", "D");
    ExerciseSupport.directedGraphAddEdge(graph, "C", "D");
    return ExerciseSupport.snapshotIterableWithStreams(ExerciseSupport.graphBfs(graph, "A"));
  }

}
