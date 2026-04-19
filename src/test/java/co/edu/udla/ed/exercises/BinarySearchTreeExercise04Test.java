package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeExercise04Test {

  @Test
  void should_remove_a_node_with_two_children_and_report_height() {
    ExerciseAssertions.assertAllResults(new BinarySearchTreeExercise04(),
        "removed=true|size=5|inOrder=[1, 2, 3, 6, 8]");
  }

}