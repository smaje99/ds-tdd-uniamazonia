package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Graph;

/**
 * Guided exercise 03 for the adjacency-list graph series.
 *
 * <p>This scenario contrasts DFS, path existence, and the shortest unweighted path. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class AdjacencyListGraphExercise03 extends AbstractAdjacencyListGraphExercise {

  @Override
  protected String solve(Graph<String> graph) {
    buildSampleGraph(graph);
    return ExerciseSupport.format(
        ExerciseSupport.named("dfs", ExerciseSupport.snapshot(graph.dfs("A"))),
        ExerciseSupport.named("hasPathAtoE", graph.hasPath("A", "E")),
        ExerciseSupport.named("shortest", ExerciseSupport.snapshot(graph.shortestPathUnweighted("A", "E"))));
  }

}