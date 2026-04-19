package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Graph;

/**
 * Guided exercise 04 for the adjacency-list graph series.
 *
 * <p>This scenario captures the error case where the traversal starts from a missing vertex. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class AdjacencyListGraphExercise04 extends AbstractAdjacencyListGraphExercise {

  @Override
  protected String solve(Graph<String> graph) {
    graph.bfs("X");
    return "unreachable";
  }

}