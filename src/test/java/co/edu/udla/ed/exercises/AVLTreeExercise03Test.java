package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class AVLTreeExercise03Test {

  @Test
  void should_rebalance_after_removing_a_value() {
    ExerciseAssertions.assertAllResults(new AVLTreeExercise03(),
        "removed=true|height=2|inOrder=[1, 2, 3]");
  }

}