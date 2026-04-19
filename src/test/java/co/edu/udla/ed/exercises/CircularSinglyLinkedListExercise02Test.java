package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class CircularSinglyLinkedListExercise02Test {

  @Test
  void should_alternate_insertions_at_both_ends() {
    ExerciseAssertions.assertAllResults(new CircularSinglyLinkedListExercise02(),
        "[inicio, A, B, C, D]");
  }

}