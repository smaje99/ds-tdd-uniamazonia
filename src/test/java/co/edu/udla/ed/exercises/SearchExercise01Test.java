package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SearchExercise01Test {

  @Test
  void should_search_unordered_linear_sequence() {
    ExerciseAssertions.assertAllResults(new SearchExercise01(), "found=true|index=1|value=azul");
  }

}
