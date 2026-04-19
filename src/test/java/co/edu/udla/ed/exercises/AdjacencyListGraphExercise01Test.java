package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class AdjacencyListGraphExercise01Test {

  @Test
  void should_report_counts_and_neighbors_for_the_sample_graph() {
    ExerciseAssertions.assertAllResults(new AdjacencyListGraphExercise01(),
        "vertices=5|edges=5|neighborsA=[B, C]|neighborsD=[B, C, E]");
  }

}