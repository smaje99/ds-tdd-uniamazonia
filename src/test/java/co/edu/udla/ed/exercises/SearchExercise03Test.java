package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SearchExercise03Test {

  @Test
  void should_search_key_value_structure() {
    ExerciseAssertions.assertAllResults(new SearchExercise03(), "found=true|key=Luis|value=85");
  }

}
