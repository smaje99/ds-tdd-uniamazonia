package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SortingExercise02Test {

  @Test
  void should_sort_with_custom_comparator() {
    ExerciseAssertions.assertAllResults(new SortingExercise02(), "sorted=[gamma, delta, beta, alpha]|first=gamma|last=alpha");
  }

}
