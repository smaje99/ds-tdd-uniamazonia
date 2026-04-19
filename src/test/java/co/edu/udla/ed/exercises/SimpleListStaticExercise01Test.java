package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SimpleListStaticExercise01Test {

  @Test
  void should_build_the_expected_snapshot() {
    ExerciseAssertions.assertAllResults(new SimpleListStaticExercise01(), "[inicio, A, B, C]");
  }

}