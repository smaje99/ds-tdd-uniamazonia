package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class AVLTreeExercise02Test {

  @Test
  void should_show_a_double_rotation_result() {
    ExerciseAssertions.assertAllResults(new AVLTreeExercise02(),
        "height=2|inOrder=[10, 20, 30]");
  }

}