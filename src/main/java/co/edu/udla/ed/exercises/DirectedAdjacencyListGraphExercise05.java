package co.edu.udla.ed.exercises;

import java.util.LinkedHashSet;
import java.util.Map;

import co.edu.udla.ed.impl.scratch.AdjacencyListGraph;

/**
 * Exercise 05 for the Directed Adjacency-List Graph series.
 *
 * <p><strong>Student task:</strong> Attempt a topological ordering on a directed cycle and observe the expected
 * exception.</p>
 */
public final class DirectedAdjacencyListGraphExercise05 {

  public String solveWithCustomIterator(AdjacencyListGraph<String> graph) {
    graph.addEdge("A", "B");
    graph.addEdge("B", "C");
    graph.addEdge("C", "A");
    graph.topologicalSort();
    return "unreachable";
  }

  public String solveWithJavaLoops(Map<String, LinkedHashSet<String>> graph) {
    ExerciseSupport.directedGraphAddEdge(graph, "A", "B");
    ExerciseSupport.directedGraphAddEdge(graph, "B", "C");
    ExerciseSupport.directedGraphAddEdge(graph, "C", "A");
    ExerciseSupport.graphTopologicalSort(graph);
    return "unreachable";
  }

  public String solveWithStreams(Map<String, LinkedHashSet<String>> graph) {
    ExerciseSupport.directedGraphAddEdge(graph, "A", "B");
    ExerciseSupport.directedGraphAddEdge(graph, "B", "C");
    ExerciseSupport.directedGraphAddEdge(graph, "C", "A");
    ExerciseSupport.graphTopologicalSort(graph);
    return "unreachable";
  }

}
