package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class QueueStaticExercise02Test {

  @Test
  void should_dequeue_in_fifo_order() {
    ExerciseAssertions.assertAllResults(new QueueStaticExercise02(),
        "dequeues=[uno, dos, tres]");
  }

}