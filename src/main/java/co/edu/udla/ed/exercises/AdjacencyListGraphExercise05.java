package co.edu.udla.ed.exercises;

import java.util.LinkedHashSet;
import java.util.Map;

import co.edu.udla.ed.impl.scratch.AdjacencyListGraph;

/**
 * Exercise 05 for the Adjacency-List Graph series.
 *
 * <p><strong>Student task:</strong> Use domain objects as vertices and validate reachability-related queries with equality-aware vertices.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class AdjacencyListGraphExercise05 {

  /**
   * Solves Exercise 05 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(AdjacencyListGraph<ExerciseSupport.Learner> graph) {
    ExerciseSupport.Learner ana = ExerciseSupport.learner("Ana", 101);
    ExerciseSupport.Learner luis = ExerciseSupport.learner("Luis", 203);
    ExerciseSupport.Learner mia = ExerciseSupport.learner("Mia", 305);
    ExerciseSupport.Learner eva = ExerciseSupport.learner("Eva", 99);
    ExerciseSupport.Learner leo = ExerciseSupport.learner("Leo", 404);
    graph.addEdge(ana, luis);
    graph.addEdge(ana, mia);
    graph.addEdge(luis, eva);
    graph.addEdge(mia, eva);
    graph.addEdge(eva, leo);
    return ExerciseSupport.format(
        ExerciseSupport.named("containsAna", ExerciseSupport.countWithIterator(graph.verticesIterable()) == 5),
        ExerciseSupport.named("bfs", ExerciseSupport.snapshotWithIterator(graph.bfsIterable(ExerciseSupport.learner("Ana", 101)))),
        ExerciseSupport.named("shortest", ExerciseSupport.snapshot(graph.shortestPathUnweighted(
            ExerciseSupport.learner("Ana", 101),
            ExerciseSupport.learner("Leo", 404)))));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(Map<ExerciseSupport.Learner, LinkedHashSet<ExerciseSupport.Learner>> graph) {
    ExerciseSupport.Learner ana = ExerciseSupport.learner("Ana", 101);
    ExerciseSupport.Learner luis = ExerciseSupport.learner("Luis", 203);
    ExerciseSupport.Learner mia = ExerciseSupport.learner("Mia", 305);
    ExerciseSupport.Learner eva = ExerciseSupport.learner("Eva", 99);
    ExerciseSupport.Learner leo = ExerciseSupport.learner("Leo", 404);
    ExerciseSupport.graphAddEdge(graph, ana, luis);
    ExerciseSupport.graphAddEdge(graph, ana, mia);
    ExerciseSupport.graphAddEdge(graph, luis, eva);
    ExerciseSupport.graphAddEdge(graph, mia, eva);
    ExerciseSupport.graphAddEdge(graph, eva, leo);
    return ExerciseSupport.format(
        ExerciseSupport.named("containsAna", graph.containsKey(ExerciseSupport.learner("Ana", 101))),
        ExerciseSupport.named("bfs", ExerciseSupport.snapshotWithLoop(ExerciseSupport.graphBfs(graph, ExerciseSupport.learner("Ana", 101)))),
        ExerciseSupport.named("shortest", ExerciseSupport.snapshotWithLoop(ExerciseSupport.graphShortestPath(
            graph,
            ExerciseSupport.learner("Ana", 101),
            ExerciseSupport.learner("Leo", 404)))));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(Map<ExerciseSupport.Learner, LinkedHashSet<ExerciseSupport.Learner>> graph) {
    ExerciseSupport.Learner ana = ExerciseSupport.learner("Ana", 101);
    ExerciseSupport.Learner luis = ExerciseSupport.learner("Luis", 203);
    ExerciseSupport.Learner mia = ExerciseSupport.learner("Mia", 305);
    ExerciseSupport.Learner eva = ExerciseSupport.learner("Eva", 99);
    ExerciseSupport.Learner leo = ExerciseSupport.learner("Leo", 404);
    ExerciseSupport.graphAddEdge(graph, ana, luis);
    ExerciseSupport.graphAddEdge(graph, ana, mia);
    ExerciseSupport.graphAddEdge(graph, luis, eva);
    ExerciseSupport.graphAddEdge(graph, mia, eva);
    ExerciseSupport.graphAddEdge(graph, eva, leo);
    return ExerciseSupport.format(
        ExerciseSupport.named("containsAna", graph.keySet().stream().anyMatch(ExerciseSupport.learner("Ana", 101)::equals)),
        ExerciseSupport.named("bfs", ExerciseSupport.snapshotWithStreams(ExerciseSupport.graphBfs(graph, ExerciseSupport.learner("Ana", 101)))),
        ExerciseSupport.named("shortest", ExerciseSupport.snapshotWithStreams(ExerciseSupport.graphShortestPath(
            graph,
            ExerciseSupport.learner("Ana", 101),
            ExerciseSupport.learner("Leo", 404)))));
  }

}
