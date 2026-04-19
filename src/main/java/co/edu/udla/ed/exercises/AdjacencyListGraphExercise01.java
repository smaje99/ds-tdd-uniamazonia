package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Graph;

/**
 * Guided exercise 01 for the adjacency-list graph series.
 *
 * <p>
 * This scenario creates an undirected graph and reports counts and adjacency
 * snapshots. The solver runs the same scripted operations on the scratch,
 * linear, and collections-based implementations and returns the feedback string
 * that the exercise tests compare against.
 * </p>
 */
public final class AdjacencyListGraphExercise01 extends AbstractAdjacencyListGraphExercise {

  @Override
  protected String solve(Graph<String> graph) {
    buildSampleGraph(graph);
    return ExerciseSupport.format(
        ExerciseSupport.named("vertices", graph.vertexCount()),
        ExerciseSupport.named("edges", graph.edgeCount()),
        ExerciseSupport.named("neighborsA", ExerciseSupport.snapshot(graph.neighbors("A"))),
        ExerciseSupport.named("neighborsD", ExerciseSupport.snapshot(graph.neighbors("D"))));
  }

}
