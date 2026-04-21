package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;
import java.util.Map;

import co.edu.udla.ed.api.WeightedGraph;
import co.edu.udla.ed.impl.scratch.AdjacencyListWeightedGraph;

/**
 * Exercise 04 for the Weighted Graph series.
 *
 * <p><strong>Student task:</strong> Build a minimum spanning tree and report its edge count and total weight.</p>
 */
public final class WeightedGraphExercise04 {

  public String solveWithCustomIterator(AdjacencyListWeightedGraph<String> graph) {
    seedWeightedGraph(graph);
    WeightedGraph<String> mst = graph.minimumSpanningTree();
    double total = mst.edgeWeight("A", "C") + mst.edgeWeight("B", "C") + mst.edgeWeight("B", "D")
        + mst.edgeWeight("D", "E");
    return ExerciseSupport.format(
        ExerciseSupport.named("edges", mst.edgeCount()),
        ExerciseSupport.named("weight", total));
  }

  public String solveWithJavaLoops(LinkedHashMap<String, LinkedHashMap<String, Double>> graph) {
    seedWeightedGraph(graph);
    Map<String, LinkedHashMap<String, Double>> mst = ExerciseSupport.weightedGraphMinimumSpanningTree(graph);
    return ExerciseSupport.format(
        ExerciseSupport.named("edges", ExerciseSupport.weightedGraphEdgeCount(mst, false)),
        ExerciseSupport.named("weight", ExerciseSupport.weightedGraphTotalWeight(mst, false)));
  }

  public String solveWithStreams(LinkedHashMap<String, LinkedHashMap<String, Double>> graph) {
    seedWeightedGraph(graph);
    Map<String, LinkedHashMap<String, Double>> mst = ExerciseSupport.weightedGraphMinimumSpanningTree(graph);
    return ExerciseSupport.format(
        ExerciseSupport.named("edges", ExerciseSupport.weightedGraphEdgeCount(mst, false)),
        ExerciseSupport.named("weight", ExerciseSupport.weightedGraphTotalWeight(mst, false)));
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
