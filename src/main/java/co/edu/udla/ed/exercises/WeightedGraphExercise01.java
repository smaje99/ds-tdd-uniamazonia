package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.AdjacencyListWeightedGraph;

/**
 * Exercise 01 for the Weighted Graph series.
 *
 * <p><strong>Student task:</strong> Build a small weighted graph and report counts together with one edge weight.</p>
 */
public final class WeightedGraphExercise01 {

  public String solveWithCustomIterator(AdjacencyListWeightedGraph<String> graph) {
    graph.addEdge("A", "B", 4.0);
    graph.addEdge("A", "C", 2.0);
    return ExerciseSupport.format(
        ExerciseSupport.named("vertices", ExerciseSupport.countWithIterator(graph.verticesIterable())),
        ExerciseSupport.named("edges", graph.edgeCount()),
        ExerciseSupport.named("AB", graph.edgeWeight("A", "B")));
  }

  public String solveWithJavaLoops(LinkedHashMap<String, LinkedHashMap<String, Double>> graph) {
    ExerciseSupport.weightedGraphAddEdge(graph, false, "A", "B", 4.0);
    ExerciseSupport.weightedGraphAddEdge(graph, false, "A", "C", 2.0);
    return ExerciseSupport.format(
        ExerciseSupport.named("vertices", graph.size()),
        ExerciseSupport.named("edges", ExerciseSupport.weightedGraphEdgeCount(graph, false)),
        ExerciseSupport.named("AB", ExerciseSupport.weightedGraphEdgeWeight(graph, "A", "B")));
  }

  public String solveWithStreams(LinkedHashMap<String, LinkedHashMap<String, Double>> graph) {
    ExerciseSupport.weightedGraphAddEdge(graph, false, "A", "B", 4.0);
    ExerciseSupport.weightedGraphAddEdge(graph, false, "A", "C", 2.0);
    return ExerciseSupport.format(
        ExerciseSupport.named("vertices", graph.keySet().stream().count()),
        ExerciseSupport.named("edges", ExerciseSupport.weightedGraphEdgeCount(graph, false)),
        ExerciseSupport.named("AB", ExerciseSupport.weightedGraphEdgeWeight(graph, "A", "B")));
  }

}
