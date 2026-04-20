package co.edu.udla.ed.exercises;

import java.util.LinkedHashSet;
import java.util.Map;

import co.edu.udla.ed.impl.scratch.AdjacencyListGraph;

public final class AdjacencyListGraphExercise05 {

  public String solveWithCustomIterator(AdjacencyListGraph<ExerciseSupport.Learner> graph) {
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
        ExerciseSupport.named("containsAna", ExerciseSupport.countWithIterator(graph.verticesIterable()) == 5),
        ExerciseSupport.named("bfs", ExerciseSupport.snapshotWithIterator(graph.bfsIterable(ExerciseSupport.learner("Ana", 101)))),
        ExerciseSupport.named("shortest", ExerciseSupport.snapshot(graph.shortestPathUnweighted(
            ExerciseSupport.learner("Ana", 101),
            ExerciseSupport.learner("Leo", 404)))));
  }

  public String solveWithJavaLoops(Map<ExerciseSupport.Learner, LinkedHashSet<ExerciseSupport.Learner>> graph) {
    ExerciseSupport.Learner ana = ExerciseSupport.learner("Ana", 101);
    ExerciseSupport.Learner luis = ExerciseSupport.learner("Luis", 203);
    ExerciseSupport.Learner mia = ExerciseSupport.learner("Mia", 305);
    ExerciseSupport.Learner eva = ExerciseSupport.learner("Eva", 99);
    ExerciseSupport.Learner leo = ExerciseSupport.learner("Leo", 404);
    ExerciseSupport.graphAddEdge(graph, ana, luis);
    ExerciseSupport.graphAddEdge(graph, ana, mia);
    ExerciseSupport.graphAddEdge(graph, luis, eva);
    ExerciseSupport.graphAddEdge(graph, mia, eva);
    ExerciseSupport.graphAddEdge(graph, eva, leo);
    return ExerciseSupport.format(
        ExerciseSupport.named("containsAna", graph.containsKey(ExerciseSupport.learner("Ana", 101))),
        ExerciseSupport.named("bfs", ExerciseSupport.snapshotWithLoop(ExerciseSupport.graphBfs(graph, ExerciseSupport.learner("Ana", 101)))),
        ExerciseSupport.named("shortest", ExerciseSupport.snapshotWithLoop(ExerciseSupport.graphShortestPath(
            graph,
            ExerciseSupport.learner("Ana", 101),
            ExerciseSupport.learner("Leo", 404)))));
  }

  public String solveWithStreams(Map<ExerciseSupport.Learner, LinkedHashSet<ExerciseSupport.Learner>> graph) {
    ExerciseSupport.Learner ana = ExerciseSupport.learner("Ana", 101);
    ExerciseSupport.Learner luis = ExerciseSupport.learner("Luis", 203);
    ExerciseSupport.Learner mia = ExerciseSupport.learner("Mia", 305);
    ExerciseSupport.Learner eva = ExerciseSupport.learner("Eva", 99);
    ExerciseSupport.Learner leo = ExerciseSupport.learner("Leo", 404);
    ExerciseSupport.graphAddEdge(graph, ana, luis);
    ExerciseSupport.graphAddEdge(graph, ana, mia);
    ExerciseSupport.graphAddEdge(graph, luis, eva);
    ExerciseSupport.graphAddEdge(graph, mia, eva);
    ExerciseSupport.graphAddEdge(graph, eva, leo);
    return ExerciseSupport.format(
        ExerciseSupport.named("containsAna", graph.keySet().stream().anyMatch(ExerciseSupport.learner("Ana", 101)::equals)),
        ExerciseSupport.named("bfs", ExerciseSupport.snapshotWithStreams(ExerciseSupport.graphBfs(graph, ExerciseSupport.learner("Ana", 101)))),
        ExerciseSupport.named("shortest", ExerciseSupport.snapshotWithStreams(ExerciseSupport.graphShortestPath(
            graph,
            ExerciseSupport.learner("Ana", 101),
            ExerciseSupport.learner("Leo", 404)))));
  }

}
