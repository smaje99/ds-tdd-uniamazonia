package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class BTreeExercise03Test {

  @Test
  void should_remove_values_and_keep_order() {
    ExerciseAssertions.assertAllResults(new BTreeExercise03(), "size=6|inOrder=[5, 7, 10, 12, 17, 30]");
  }

}
