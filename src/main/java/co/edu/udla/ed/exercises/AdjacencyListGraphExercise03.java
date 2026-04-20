package co.edu.udla.ed.exercises;

import java.util.LinkedHashSet;
import java.util.Map;

import co.edu.udla.ed.impl.scratch.AdjacencyListGraph;

public final class AdjacencyListGraphExercise03 {

  public String solveWithCustomIterator(AdjacencyListGraph<String> graph) {
    buildSampleGraph(graph);
    return ExerciseSupport.format(
        ExerciseSupport.named("dfs", ExerciseSupport.snapshotWithIterator(graph.dfsIterable("A"))),
        ExerciseSupport.named("hasPathAtoE", graph.hasPath("A", "E")),
        ExerciseSupport.named("shortest", ExerciseSupport.snapshot(graph.shortestPathUnweighted("A", "E"))));
  }

  public String solveWithJavaLoops(Map<String, LinkedHashSet<String>> graph) {
    buildSampleGraph(graph);
    return ExerciseSupport.format(
        ExerciseSupport.named("dfs", ExerciseSupport.snapshotWithLoop(ExerciseSupport.graphDfs(graph, "A"))),
        ExerciseSupport.named("hasPathAtoE", ExerciseSupport.graphHasPath(graph, "A", "E")),
        ExerciseSupport.named("shortest", ExerciseSupport.snapshotWithLoop(ExerciseSupport.graphShortestPath(graph, "A", "E"))));
  }

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
