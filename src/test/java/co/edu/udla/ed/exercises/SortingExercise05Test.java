package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SortingExercise05Test {

  @Test
  void should_sort_domain_objects_without_mutating_original_order() {
    ExerciseAssertions.assertAllResults(new SortingExercise05(), "original=[Ana@2, Luis@1, Eva@3]|sorted=[Luis@1, Ana@2, Eva@3]");
  }

}
