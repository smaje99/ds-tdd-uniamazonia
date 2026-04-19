package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeExercise03Test {

  @Test
  void should_remove_a_leaf_and_keep_the_sorted_order() {
    ExerciseAssertions.assertAllResults(new BinarySearchTreeExercise03(),
        "removed=true|inOrder=[1, 2, 5, 6, 8]");
  }

}