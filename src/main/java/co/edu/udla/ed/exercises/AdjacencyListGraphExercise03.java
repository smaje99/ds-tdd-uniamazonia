package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Graph;

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