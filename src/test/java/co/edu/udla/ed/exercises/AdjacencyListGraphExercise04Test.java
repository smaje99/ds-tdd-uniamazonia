package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class AdjacencyListGraphExercise04Test {

  @Test
  void should_throw_when_the_start_vertex_does_not_exist() {
    ExerciseAssertions.assertAllThrow(new AdjacencyListGraphExercise04(), IllegalArgumentException.class);
  }

}