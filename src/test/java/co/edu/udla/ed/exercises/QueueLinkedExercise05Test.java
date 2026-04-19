package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class QueueLinkedExercise05Test {

  @Test
  void should_use_domain_objects_in_the_linked_queue() {
    ExerciseAssertions.assertAllResults(new QueueLinkedExercise05(),
        "served=Eva#99|peekIsAna=true|remaining=[Ana#101, Luis#203, Mia#305]");
  }

}
