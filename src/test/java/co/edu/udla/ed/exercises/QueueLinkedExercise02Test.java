package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class QueueLinkedExercise02Test {

  @Test
  void should_remove_values_in_fifo_order() {
    ExerciseAssertions.assertAllResults(new QueueLinkedExercise02(), "dequeues=[A, B, C]");
  }

}