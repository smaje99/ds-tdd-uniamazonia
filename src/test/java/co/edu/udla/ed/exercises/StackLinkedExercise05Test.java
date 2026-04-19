package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class StackLinkedExercise05Test {

  @Test
  void should_use_domain_objects_in_the_linked_stack() {
    ExerciseAssertions.assertAllResults(new StackLinkedExercise05(),
        "peekIsMia=true|drain=[Mia#305, Ana#101, Eva#99]");
  }

}
