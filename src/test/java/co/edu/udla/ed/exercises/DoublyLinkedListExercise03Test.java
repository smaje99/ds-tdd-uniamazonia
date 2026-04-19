package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class DoublyLinkedListExercise03Test {

  @Test
  void should_report_first_middle_and_last_positions() {
    ExerciseAssertions.assertAllResults(new DoublyLinkedListExercise03(),
        "first=uno|middle=tres|last=cinco");
  }

}