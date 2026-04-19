package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class StackLinkedExercise04Test {

  @Test
  void should_unstack_the_complete_sequence() {
    ExerciseAssertions.assertAllResults(new StackLinkedExercise04(),
        "pops=[quinto, cuarto, tercero, segundo, primero]");
  }

}