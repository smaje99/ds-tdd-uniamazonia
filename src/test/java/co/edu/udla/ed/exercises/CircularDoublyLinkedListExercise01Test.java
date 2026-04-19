package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class CircularDoublyLinkedListExercise01Test {

  @Test
  void should_show_the_basic_circular_order() {
    ExerciseAssertions.assertAllResults(new CircularDoublyLinkedListExercise01(),
        "[uno, dos, tres]");
  }

}