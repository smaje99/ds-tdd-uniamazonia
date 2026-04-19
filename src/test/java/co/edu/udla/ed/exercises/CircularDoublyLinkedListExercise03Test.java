package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class CircularDoublyLinkedListExercise03Test {

  @Test
  void should_remove_everything_and_start_again() {
    ExerciseAssertions.assertAllResults(new CircularDoublyLinkedListExercise03(),
        "removed=[A, D, B, C]|remaining=[reinicio]");
  }

}