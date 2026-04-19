package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Graph;

/**
 * Guided exercise 02 for the adjacency-list graph series.
 *
 * <p>This scenario reports the deterministic breadth-first traversal used by the repository. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class AdjacencyListGraphExercise02 extends AbstractAdjacencyListGraphExercise {

  @Override
  protected String solve(Graph<String> graph) {
    buildSampleGraph(graph);
    return ExerciseSupport.named("bfs", ExerciseSupport.snapshot(graph.bfs("A")));
  }

}