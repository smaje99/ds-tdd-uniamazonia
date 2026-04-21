package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.AdjacencyListWeightedGraph;

/**
 * Exercise 05 for the Weighted Graph series.
 *
 * <p><strong>Student task:</strong> Attempt to insert a negative weight and observe the expected exception.</p>
 */
public final class WeightedGraphExercise05 {

  public String solveWithCustomIterator(AdjacencyListWeightedGraph<String> graph) {
    graph.addEdge("A", "B", -1.0);
    return "unreachable";
  }

  public String solveWithJavaLoops(LinkedHashMap<String, LinkedHashMap<String, Double>> graph) {
    ExerciseSupport.weightedGraphAddEdge(graph, false, "A", "B", -1.0);
    return "unreachable";
  }

  public String solveWithStreams(LinkedHashMap<String, LinkedHashMap<String, Double>> graph) {
    ExerciseSupport.weightedGraphAddEdge(graph, false, "A", "B", -1.0);
    return "unreachable";
  }

}
