package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class OpenAddressingHashTableExercise03Test {

  @Test
  void should_remove_a_key() {
    ExerciseAssertions.assertAllResults(new OpenAddressingHashTableExercise03(), "removed=20|containsB=false|size=2");
  }

}
