package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class StackStaticExercise02Test {

  @Test
  void should_pop_in_lifo_order() {
    ExerciseAssertions.assertAllResults(new StackStaticExercise02(), "pops=[tres, dos, uno]");
  }

}