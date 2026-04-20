package co.edu.udla.ed.exercises;

import java.util.LinkedHashSet;
import java.util.Map;

import co.edu.udla.ed.impl.scratch.AdjacencyListGraph;

public final class AdjacencyListGraphExercise04 {

  public String solveWithCustomIterator(AdjacencyListGraph<String> graph) {
    graph.bfs("X");
    return "unreachable";
  }

  public String solveWithJavaLoops(Map<String, LinkedHashSet<String>> graph) {
    ExerciseSupport.graphBfs(graph, "X");
    return "unreachable";
  }

  public String solveWithStreams(Map<String, LinkedHashSet<String>> graph) {
    ExerciseSupport.graphBfs(graph, "X");
    return "unreachable";
  }

}
