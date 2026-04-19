package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class DoublyLinkedListExercise01Test {

  @Test
  void should_build_an_ordered_list() {
    ExerciseAssertions.assertAllResults(new DoublyLinkedListExercise01(),
        "[lunes, martes, miércoles, jueves]");
  }

}