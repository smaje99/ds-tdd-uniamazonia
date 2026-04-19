package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Graph;
import co.edu.udla.ed.impl.collections.CollectionsAdjacencyListGraph;
import co.edu.udla.ed.impl.linear.LinearAdjacencyListGraph;
import co.edu.udla.ed.impl.scratch.AdjacencyListGraph;

/**
 * Base wiring for the adjacency-list graph exercise series that uses string vertices.
 */
abstract class AbstractAdjacencyListGraphExercise extends AbstractGraphExercise<String> {

  @Override
  protected Graph<String> createScratch() {
    return new AdjacencyListGraph<>(false);
  }

  @Override
  protected Graph<String> createLinear() {
    return new LinearAdjacencyListGraph<>(false);
  }

  @Override
  protected Graph<String> createCollections() {
    return new CollectionsAdjacencyListGraph<>(false);
  }

  protected final Graph<String> buildSampleGraph(Graph<String> graph) {
    graph.addEdge("A", "B");
    graph.addEdge("A", "C");
    graph.addEdge("B", "D");
    graph.addEdge("C", "D");
    graph.addEdge("D", "E");
    return graph;
  }

}

/**
 * Base wiring for the adjacency-list graph exercise series that uses learner domain objects.
 */
abstract class AbstractAdjacencyListGraphDomainExercise extends AbstractGraphExercise<ExerciseSupport.Learner> {

  @Override
  protected Graph<ExerciseSupport.Learner> createScratch() {
    return new AdjacencyListGraph<>(false);
  }

  @Override
  protected Graph<ExerciseSupport.Learner> createLinear() {
    return new LinearAdjacencyListGraph<>(false);
  }

  @Override
  protected Graph<ExerciseSupport.Learner> createCollections() {
    return new CollectionsAdjacencyListGraph<>(false);
  }

}
