package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class OpenAddressingHashTableExercise04Test {

  @Test
  void should_preserve_collision_heavy_keys() {
    ExerciseAssertions.assertAllResults(new OpenAddressingHashTableExercise04(), "A=10|B=20|C=30");
  }

}
