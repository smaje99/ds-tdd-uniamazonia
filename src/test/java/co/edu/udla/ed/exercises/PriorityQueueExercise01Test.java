package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class PriorityQueueExercise01Test {

  @Test
  void should_report_size_and_minimum() {
    ExerciseAssertions.assertAllResults(new PriorityQueueExercise01(), "size=3|min=1");
  }

}
