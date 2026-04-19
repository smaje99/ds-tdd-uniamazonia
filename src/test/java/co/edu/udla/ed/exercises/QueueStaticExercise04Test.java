package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class QueueStaticExercise04Test {

  @Test
  void should_preserve_logical_order_after_wraparound_and_growth() {
    ExerciseAssertions.assertAllResults(new QueueStaticExercise04(),
        "dequeues=[3, 4, 5, 6, 7, 8, 9, 10, 11, 12]");
  }

}