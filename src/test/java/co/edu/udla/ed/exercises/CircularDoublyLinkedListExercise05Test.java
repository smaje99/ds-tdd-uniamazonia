package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class CircularDoublyLinkedListExercise05Test {

  @Test
  void should_use_domain_objects_in_the_circular_doubly_linked_list() {
    ExerciseAssertions.assertAllResults(new CircularDoublyLinkedListExercise05(),
        "removed=Luis#203|containsAna=true|snapshot=[Eva#99, Ana#101]");
  }

}
