package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class DoublyLinkedListExercise05Test {

  @Test
  void should_use_domain_objects_in_the_doubly_linked_list() {
    ExerciseAssertions.assertAllResults(new DoublyLinkedListExercise05(),
        "middleIsLuis=true|snapshot=[Ana#101, Luis#203, Mia#305]");
  }

}
