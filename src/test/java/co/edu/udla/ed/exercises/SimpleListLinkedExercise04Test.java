package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SimpleListLinkedExercise04Test {

  @Test
  void should_reproduce_the_mixed_command_sequence() {
    ExerciseAssertions.assertAllResults(new SimpleListLinkedExercise04(),
        "[cabecera, uno, dos, tres, cuatro, cinco]");
  }

}