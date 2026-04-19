package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class CircularSinglyLinkedListExercise01Test {

  @Test
  void should_move_from_empty_to_many_nodes() {
    ExerciseAssertions.assertAllResults(new CircularSinglyLinkedListExercise01(),
        "[inicio, A, B]");
  }

}