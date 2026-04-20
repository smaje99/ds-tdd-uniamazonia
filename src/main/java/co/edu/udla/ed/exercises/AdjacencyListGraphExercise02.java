package co.edu.udla.ed.exercises;

import java.util.LinkedHashSet;
import java.util.Map;

import co.edu.udla.ed.impl.scratch.AdjacencyListGraph;

public final class AdjacencyListGraphExercise02 {

  public String solveWithCustomIterator(AdjacencyListGraph<String> graph) {
    buildSampleGraph(graph);
    return ExerciseSupport.named("bfs", ExerciseSupport.snapshotWithIterator(graph.bfsIterable("A")));
  }

  public String solveWithJavaLoops(Map<String, LinkedHashSet<String>> graph) {
    buildSampleGraph(graph);
    return ExerciseSupport.named("bfs", ExerciseSupport.snapshotWithLoop(ExerciseSupport.graphBfs(graph, "A")));
  }

  public String solveWithStreams(Map<String, LinkedHashSet<String>> graph) {
    buildSampleGraph(graph);
    return ExerciseSupport.named("bfs", ExerciseSupport.snapshotWithStreams(ExerciseSupport.graphBfs(graph, "A")));
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
