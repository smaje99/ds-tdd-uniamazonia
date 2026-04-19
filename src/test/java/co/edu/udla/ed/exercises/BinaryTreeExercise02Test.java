package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class BinaryTreeExercise02Test {

  @Test
  void should_report_height_and_level_order() {
    ExerciseAssertions.assertAllResults(new BinaryTreeExercise02(),
        "height=3|levelOrder=[A, B, C, D, E, F]");
  }

}