package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SimpleListLinkedExercise02Test {

  @Test
  void should_remove_values_from_both_ends() {
    ExerciseAssertions.assertAllResults(new SimpleListLinkedExercise02(),
        "removed=[A, E, B]|remaining=[C, D]");
  }

}