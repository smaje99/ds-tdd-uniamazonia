package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class RedBlackTreeExercise03Test {

  @Test
  void should_remove_values_and_keep_order() {
    ExerciseAssertions.assertAllResults(new RedBlackTreeExercise03(), "size=5|inOrder=[5, 7, 12, 15, 18]");
  }

}
