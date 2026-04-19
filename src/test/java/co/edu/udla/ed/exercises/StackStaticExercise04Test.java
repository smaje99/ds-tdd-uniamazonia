package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class StackStaticExercise04Test {

  @Test
  void should_keep_lifo_even_after_growing() {
    ExerciseAssertions.assertAllResults(new StackStaticExercise04(),
        "pops=[11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]");
  }

}