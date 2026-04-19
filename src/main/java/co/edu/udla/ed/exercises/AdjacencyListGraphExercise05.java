package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Graph;

public final class AdjacencyListGraphExercise05 extends AbstractAdjacencyListGraphDomainExercise {

  @Override
  protected String solve(Graph<ExerciseSupport.Learner> graph) {
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
        ExerciseSupport.named("containsAna", graph.containsVertex(ExerciseSupport.learner("Ana", 101))),
        ExerciseSupport.named("bfs", ExerciseSupport.snapshot(graph.bfs(ExerciseSupport.learner("Ana", 101)))),
        ExerciseSupport.named("shortest",
            ExerciseSupport.snapshot(graph.shortestPathUnweighted(
                ExerciseSupport.learner("Ana", 101),
                ExerciseSupport.learner("Leo", 404)))));
  }

}
