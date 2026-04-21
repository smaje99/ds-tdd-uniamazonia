package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.AdjacencyListWeightedGraph;

/**
 * Exercise 02 for the Weighted Graph series.
 *
 * <p><strong>Student task:</strong> Compute Dijkstra distances from a start vertex.</p>
 */
public final class WeightedGraphExercise02 {

  public String solveWithCustomIterator(AdjacencyListWeightedGraph<String> graph) {
    seedWeightedGraph(graph);
    LinkedHashMap<String, Double> distances = new LinkedHashMap<>(graph.dijkstraDistances("A"));
    return ExerciseSupport.format(
        ExerciseSupport.named("A", distances.get("A")),
        ExerciseSupport.named("B", distances.get("B")),
        ExerciseSupport.named("C", distances.get("C")),
        ExerciseSupport.named("D", distances.get("D")),
        ExerciseSupport.named("E", distances.get("E")));
  }

  public String solveWithJavaLoops(LinkedHashMap<String, LinkedHashMap<String, Double>> graph) {
    seedWeightedGraph(graph);
    LinkedHashMap<String, Double> distances = ExerciseSupport.weightedGraphDijkstra(graph, "A");
    return ExerciseSupport.format(
        ExerciseSupport.named("A", distances.get("A")),
        ExerciseSupport.named("B", distances.get("B")),
        ExerciseSupport.named("C", distances.get("C")),
        ExerciseSupport.named("D", distances.get("D")),
        ExerciseSupport.named("E", distances.get("E")));
  }

  public String solveWithStreams(LinkedHashMap<String, LinkedHashMap<String, Double>> graph) {
    seedWeightedGraph(graph);
    LinkedHashMap<String, Double> distances = ExerciseSupport.weightedGraphDijkstra(graph, "A");
    return ExerciseSupport.format(
        ExerciseSupport.named("A", distances.get("A")),
        ExerciseSupport.named("B", distances.get("B")),
        ExerciseSupport.named("C", distances.get("C")),
        ExerciseSupport.named("D", distances.get("D")),
        ExerciseSupport.named("E", distances.get("E")));
  }

  private void seedWeightedGraph(AdjacencyListWeightedGraph<String> graph) {
    graph.addEdge("A", "B", 4.0);
    graph.addEdge("A", "C", 2.0);
    graph.addEdge("B", "C", 1.0);
    graph.addEdge("B", "D", 5.0);
    graph.addEdge("C", "D", 8.0);
    graph.addEdge("C", "E", 10.0);
    graph.addEdge("D", "E", 2.0);
  }

  private void seedWeightedGraph(LinkedHashMap<String, LinkedHashMap<String, Double>> graph) {
    ExerciseSupport.weightedGraphAddEdge(graph, false, "A", "B", 4.0);
    ExerciseSupport.weightedGraphAddEdge(graph, false, "A", "C", 2.0);
    ExerciseSupport.weightedGraphAddEdge(graph, false, "B", "C", 1.0);
    ExerciseSupport.weightedGraphAddEdge(graph, false, "B", "D", 5.0);
    ExerciseSupport.weightedGraphAddEdge(graph, false, "C", "D", 8.0);
    ExerciseSupport.weightedGraphAddEdge(graph, false, "C", "E", 10.0);
    ExerciseSupport.weightedGraphAddEdge(graph, false, "D", "E", 2.0);
  }

}
