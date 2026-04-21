package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SearchExercise04Test {

  @Test
  void should_search_ordered_tree() {
    ExerciseAssertions.assertAllResults(new SearchExercise04(), "found=true|target=6|visited=[1, 3, 6]");
  }

}
