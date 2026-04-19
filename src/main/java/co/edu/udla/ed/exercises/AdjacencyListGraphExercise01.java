package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Graph;

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