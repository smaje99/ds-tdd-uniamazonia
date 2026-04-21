package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class PriorityQueueExercise02Test {

  @Test
  void should_drain_in_priority_order() {
    ExerciseAssertions.assertAllResults(new PriorityQueueExercise02(), "[1, 3, 5, 7]");
  }

}
