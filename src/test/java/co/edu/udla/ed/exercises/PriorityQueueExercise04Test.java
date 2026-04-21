package co.edu.udla.ed.exercises;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

public class PriorityQueueExercise04Test {

  @Test
  void should_throw_when_removing_from_empty_queue() {
    ExerciseAssertions.assertAllThrow(new PriorityQueueExercise04(), NoSuchElementException.class);
  }

}
