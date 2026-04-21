package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class WeightedGraphExercise03Test {

  @Test
  void should_compute_shortest_weighted_path() {
    ExerciseAssertions.assertAllResults(new WeightedGraphExercise03(), "[A, C, B, D, E]");
  }

}
