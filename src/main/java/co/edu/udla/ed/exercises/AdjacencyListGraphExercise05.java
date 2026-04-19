package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Graph;

/**
 * Guided exercise 05 for the adjacency-list graph series.
 *
 * <p>This scenario uses learner domain objects as vertices so reachability depends on vertex equality semantics. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
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
