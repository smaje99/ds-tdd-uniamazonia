package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class DisjointSetExercise01Test {

  @Test
  void should_register_independent_sets() {
    ExerciseAssertions.assertAllResults(new DisjointSetExercise01(), "size=3|sets=3|findA=A");
  }

}
