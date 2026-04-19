package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeExercise01Test {

  @Test
  void should_return_sorted_in_order_after_insertions() {
    ExerciseAssertions.assertAllResults(new BinarySearchTreeExercise01(),
        "inOrder=[1, 2, 3, 5, 8]");
  }

}