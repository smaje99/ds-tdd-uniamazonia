package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class AVLTreeExercise01Test {

  @Test
  void should_show_a_simple_rotation_result() {
    ExerciseAssertions.assertAllResults(new AVLTreeExercise01(),
        "height=2|inOrder=[10, 20, 30]");
  }

}