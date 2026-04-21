package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class WeightedGraphExercise05Test {

  @Test
  void should_throw_for_negative_weights() {
    ExerciseAssertions.assertAllThrow(new WeightedGraphExercise05(), IllegalArgumentException.class);
  }

}
