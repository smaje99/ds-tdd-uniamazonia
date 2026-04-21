package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class DirectedAdjacencyListGraphExercise04Test {

  @Test
  void should_compute_topological_order() {
    ExerciseAssertions.assertAllResults(new DirectedAdjacencyListGraphExercise04(), "[A, B, C, D, E]");
  }

}
