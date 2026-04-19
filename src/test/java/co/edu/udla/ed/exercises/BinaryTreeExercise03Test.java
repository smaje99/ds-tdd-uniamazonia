package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class BinaryTreeExercise03Test {

  @Test
  void should_return_in_order_and_post_order() {
    ExerciseAssertions.assertAllResults(new BinaryTreeExercise03(),
        "inOrder=[D, B, E, A, C, F]|postOrder=[D, E, B, F, C, A]");
  }

}