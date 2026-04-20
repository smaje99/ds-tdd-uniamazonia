package co.edu.udla.ed.exercises;

import java.util.LinkedHashSet;
import java.util.Map;

import co.edu.udla.ed.impl.scratch.AdjacencyListGraph;

public final class AdjacencyListGraphExercise01 {

  public String solveWithCustomIterator(AdjacencyListGraph<String> graph) {
    buildSampleGraph(graph);
    return ExerciseSupport.format(
        ExerciseSupport.named("vertices", ExerciseSupport.countWithIterator(graph.verticesIterable())),
        ExerciseSupport.named("edges", graph.edgeCount()),
        ExerciseSupport.named("neighborsA", ExerciseSupport.snapshotWithIterator(graph.neighborsIterable("A"))),
        ExerciseSupport.named("neighborsD", ExerciseSupport.snapshotWithIterator(graph.neighborsIterable("D"))));
  }

  public String solveWithJavaLoops(Map<String, LinkedHashSet<String>> graph) {
    buildSampleGraph(graph);
    return ExerciseSupport.format(
        ExerciseSupport.named("vertices", graph.size()),
        ExerciseSupport.named("edges", ExerciseSupport.graphEdgeCount(graph)),
        ExerciseSupport.named("neighborsA", ExerciseSupport.snapshotCollectionWithLoop(graph.get("A"))),
        ExerciseSupport.named("neighborsD", ExerciseSupport.snapshotCollectionWithLoop(graph.get("D"))));
  }

  public String solveWithStreams(Map<String, LinkedHashSet<String>> graph) {
    buildSampleGraph(graph);
    return ExerciseSupport.format(
        ExerciseSupport.named("vertices", graph.keySet().stream().count()),
        ExerciseSupport.named("edges", ExerciseSupport.graphEdgeCount(graph)),
        ExerciseSupport.named("neighborsA", ExerciseSupport.snapshotWithStreams(graph.get("A"))),
        ExerciseSupport.named("neighborsD", ExerciseSupport.snapshotWithStreams(graph.get("D"))));
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
