package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class RedBlackTreeExercise01Test {

  @Test
  void should_report_sorted_state() {
    ExerciseAssertions.assertAllResults(new RedBlackTreeExercise01(), "size=5|height=3|inOrder=[1, 2, 3, 5, 8]");
  }

}
