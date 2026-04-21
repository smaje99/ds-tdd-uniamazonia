package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class DisjointSetExercise04Test {

  @Test
  void should_throw_when_querying_missing_element() {
    ExerciseAssertions.assertAllThrow(new DisjointSetExercise04(), IllegalArgumentException.class);
  }

}
