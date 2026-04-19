package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class BinaryTreeExercise01Test {

  @Test
  void should_return_pre_order_for_the_fixed_tree() {
    ExerciseAssertions.assertAllResults(new BinaryTreeExercise01(),
        "preOrder=[A, B, D, E, C, F]");
  }

}