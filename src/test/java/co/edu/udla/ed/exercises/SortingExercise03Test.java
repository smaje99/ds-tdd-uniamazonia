package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SortingExercise03Test {

  @Test
  void should_sort_duplicates_and_count_repeated_values() {
    ExerciseAssertions.assertAllResults(new SortingExercise03(), "sorted=[1, 1, 3, 5, 5]|countOf1=2");
  }

}
