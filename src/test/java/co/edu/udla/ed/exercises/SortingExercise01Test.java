package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SortingExercise01Test {

  @Test
  void should_compare_original_and_sorted_snapshots() {
    ExerciseAssertions.assertAllResults(new SortingExercise01(), "original=[4, 1, 3, 2]|sorted=[1, 2, 3, 4]");
  }

}
