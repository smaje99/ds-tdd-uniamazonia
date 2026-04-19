package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class QueueLinkedExercise04Test {

  @Test
  void should_drain_the_rebuilt_queue_in_order() {
    ExerciseAssertions.assertAllResults(new QueueLinkedExercise04(),
        "dequeues=[tres, cuatro, cinco]");
  }

}