package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Graph;

public final class AdjacencyListGraphExercise04 extends AbstractAdjacencyListGraphExercise {

  @Override
  protected String solve(Graph<String> graph) {
    graph.bfs("X");
    return "unreachable";
  }

}