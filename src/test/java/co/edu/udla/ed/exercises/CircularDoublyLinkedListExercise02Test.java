package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class CircularDoublyLinkedListExercise02Test {

  @Test
  void should_alternate_extremes_and_report_a_middle_value() {
    ExerciseAssertions.assertAllResults(new CircularDoublyLinkedListExercise02(),
        "snapshot=[A, B, C, D]|middle=C");
  }

}