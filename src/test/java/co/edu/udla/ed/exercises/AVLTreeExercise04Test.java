package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class AVLTreeExercise04Test {

  @Test
  void should_keep_the_tree_balanced_after_mixed_operations() {
    ExerciseAssertions.assertAllResults(new AVLTreeExercise04(),
        "contains25=true|height=3|inOrder=[10, 20, 25, 30, 40]");
  }

}