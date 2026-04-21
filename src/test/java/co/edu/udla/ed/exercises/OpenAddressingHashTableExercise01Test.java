package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class OpenAddressingHashTableExercise01Test {

  @Test
  void should_store_basic_pairs() {
    ExerciseAssertions.assertAllResults(new OpenAddressingHashTableExercise01(), "size=2|getA=10|getB=20");
  }

}
