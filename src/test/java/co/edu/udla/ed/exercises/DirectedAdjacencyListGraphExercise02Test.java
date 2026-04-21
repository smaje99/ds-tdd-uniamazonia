package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class DirectedAdjacencyListGraphExercise02Test {

  @Test
  void should_traverse_with_bfs() {
    ExerciseAssertions.assertAllResults(new DirectedAdjacencyListGraphExercise02(), "[A, B, C, D]");
  }

}
