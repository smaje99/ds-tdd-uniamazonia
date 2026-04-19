package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class CircularSinglyLinkedListExercise04Test {

  @Test
  void should_keep_order_after_a_mixed_sequence() {
    ExerciseAssertions.assertAllResults(new CircularSinglyLinkedListExercise04(),
        "[ancla, sol, luna, estrella]");
  }

}