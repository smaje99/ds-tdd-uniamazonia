package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SearchExercise02Test {

  @Test
  void should_search_ordered_linear_sequence() {
    ExerciseAssertions.assertAllResults(new SearchExercise02(), "found=true|index=3|value=8");
  }

}
