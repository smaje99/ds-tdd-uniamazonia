package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Graph;

public final class AdjacencyListGraphExercise02 extends AbstractAdjacencyListGraphExercise {

  @Override
  protected String solve(Graph<String> graph) {
    buildSampleGraph(graph);
    return ExerciseSupport.named("bfs", ExerciseSupport.snapshot(graph.bfs("A")));
  }

}