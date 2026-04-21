package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import co.edu.udla.ed.api.GraphSearchResult;
import co.edu.udla.ed.common.JavaSearchAdapters;
import co.edu.udla.ed.impl.scratch.AdjacencyListGraph;
import co.edu.udla.ed.impl.scratch.search.BreadthFirstSearch;

/**
 * Exercise 05 for the Search series.
 *
 * <p><strong>Student task:</strong> Search reachability in a graph and report the traversal plus
 * a shortest path to the target.</p>
 */
public final class SearchExercise05 {

  public String solveWithCustomIterator(AdjacencyListGraph<String> graph) {
    graph.addEdge("A", "B");
    graph.addEdge("A", "C");
    graph.addEdge("B", "D");
    graph.addEdge("C", "E");
    GraphSearchResult<String> result = new BreadthFirstSearch<String>().search(graph, "A", "E");
    return format(result);
  }

  public String solveWithJavaLoops(LinkedHashMap<String, LinkedHashSet<String>> graph) {
    ExerciseSupport.graphAddEdge(graph, "A", "B");
    ExerciseSupport.graphAddEdge(graph, "A", "C");
    ExerciseSupport.graphAddEdge(graph, "B", "D");
    ExerciseSupport.graphAddEdge(graph, "C", "E");
    GraphSearchResult<String> result = JavaSearchAdapters.breadthFirstSearch(graph, "A", "E");
    return format(result);
  }

  public String solveWithStreams(LinkedHashMap<String, LinkedHashSet<String>> graph) {
    ExerciseSupport.graphAddEdge(graph, "A", "B");
    ExerciseSupport.graphAddEdge(graph, "A", "C");
    ExerciseSupport.graphAddEdge(graph, "B", "D");
    ExerciseSupport.graphAddEdge(graph, "C", "E");
    GraphSearchResult<String> result = JavaSearchAdapters.breadthFirstSearch(graph, "A", "E");
    return format(result);
  }

  private String format(GraphSearchResult<String> result) {
    return ExerciseSupport.format(
        ExerciseSupport.named("found", result.found()),
        ExerciseSupport.named("visited", result.visited()),
        ExerciseSupport.named("path", result.path()));
  }

}
