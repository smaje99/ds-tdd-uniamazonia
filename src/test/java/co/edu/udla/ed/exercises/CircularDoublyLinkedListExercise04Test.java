package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class CircularDoublyLinkedListExercise04Test {

  @Test
  void should_rebuild_after_a_full_reset() {
    ExerciseAssertions.assertAllResults(new CircularDoublyLinkedListExercise04(),
        "[nuevo-inicio, nuevo-final, cierre]");
  }

}