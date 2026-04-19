package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class CircularSinglyLinkedListExercise05Test {

  @Test
  void should_use_domain_objects_in_the_circular_singly_linked_list() {
    ExerciseAssertions.assertAllResults(new CircularSinglyLinkedListExercise05(),
        "removed=Luis#203|snapshot=[Eva#99, Ana#101, Mia#305]");
  }

}
