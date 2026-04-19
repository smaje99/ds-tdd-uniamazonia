package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class DoublyLinkedListExercise04Test {

  @Test
  void should_clear_and_rebuild_the_structure() {
    ExerciseAssertions.assertAllResults(new DoublyLinkedListExercise04(),
        "[nuevo-0, nuevo-1, nuevo-2]");
  }

}