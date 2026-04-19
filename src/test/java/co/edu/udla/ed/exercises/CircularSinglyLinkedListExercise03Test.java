package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class CircularSinglyLinkedListExercise03Test {

  @Test
  void should_empty_the_list_and_reuse_it() {
    ExerciseAssertions.assertAllResults(new CircularSinglyLinkedListExercise03(),
        "removed=[A, C, B]|remaining=[reinicio]");
  }

}