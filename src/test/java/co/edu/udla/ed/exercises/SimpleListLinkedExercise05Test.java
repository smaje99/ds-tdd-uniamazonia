package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SimpleListLinkedExercise05Test {

  @Test
  void should_use_domain_objects_in_the_linked_simple_list() {
    ExerciseAssertions.assertAllResults(new SimpleListLinkedExercise05(),
        "removed=Mia#305|containsAna=true|snapshot=[Ana#101, Luis#203, Leo#404]");
  }

}
