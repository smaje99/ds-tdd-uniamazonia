package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class AdjacencyListGraphExercise02Test {

  @Test
  void should_return_the_deterministic_bfs_order() {
    ExerciseAssertions.assertAllResults(new AdjacencyListGraphExercise02(),
        "bfs=[A, B, C, D, E]");
  }

}