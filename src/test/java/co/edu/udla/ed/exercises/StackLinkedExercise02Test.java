package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class StackLinkedExercise02Test {

  @Test
  void should_pop_values_in_reverse_order() {
    ExerciseAssertions.assertAllResults(new StackLinkedExercise02(), "pops=[C, B, A]");
  }

}