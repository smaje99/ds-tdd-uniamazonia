package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class DirectedAdjacencyListGraphExercise03Test {

  @Test
  void should_compute_directed_shortest_path() {
    ExerciseAssertions.assertAllResults(new DirectedAdjacencyListGraphExercise03(), "[A, B, D, E]");
  }

}
