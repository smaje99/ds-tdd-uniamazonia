package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class QueueLinkedExercise03Test {

  @Test
  void should_handle_interleaved_queue_operations() {
    ExerciseAssertions.assertAllResults(new QueueLinkedExercise03(),
        "firstOut=n1|peek=n2|size=2");
  }

}