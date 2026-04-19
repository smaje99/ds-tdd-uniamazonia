package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class BinaryTreeExercise05Test {

  @Test
  void should_use_domain_objects_in_the_binary_tree() {
    ExerciseAssertions.assertAllResults(new BinaryTreeExercise05(),
        "preOrder=[Ana#101, Luis#203, Eva#99, Mia#305]|levelOrder=[Ana#101, Luis#203, Mia#305, Eva#99]");
  }

}
