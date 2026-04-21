package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class OpenAddressingHashTableExercise02Test {

  @Test
  void should_overwrite_without_growing() {
    ExerciseAssertions.assertAllResults(new OpenAddressingHashTableExercise02(), "previous=10|size=1|current=99");
  }

}
