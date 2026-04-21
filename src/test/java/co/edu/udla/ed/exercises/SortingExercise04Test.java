package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SortingExercise04Test {

  @Test
  void should_use_integer_only_sorting_algorithm() {
    ExerciseAssertions.assertAllResults(new SortingExercise04(), "sorted=[0, 1, 2, 2, 4]|size=5");
  }

}
