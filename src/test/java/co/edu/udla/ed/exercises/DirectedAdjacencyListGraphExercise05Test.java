package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class DirectedAdjacencyListGraphExercise05Test {

  @Test
  void should_throw_for_directed_cycles() {
    ExerciseAssertions.assertAllThrow(new DirectedAdjacencyListGraphExercise05(), IllegalStateException.class);
  }

}
