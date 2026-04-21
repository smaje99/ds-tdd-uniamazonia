package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SearchExercise05Test {

  @Test
  void should_search_graph_reachability_and_path() {
    ExerciseAssertions.assertAllResults(new SearchExercise05(), "found=true|visited=[A, B, C, D, E]|path=[A, C, E]");
  }

}
