package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class PriorityQueueExercise05Test {

  @Test
  void should_clear_and_rebuild_queue() {
    ExerciseAssertions.assertAllResults(new PriorityQueueExercise05(), "size=2|drain=[1, 6]");
  }

}
