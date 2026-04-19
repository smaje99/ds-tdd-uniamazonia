package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SimpleListStaticExercise05Test {

  @Test
  void should_use_domain_objects_in_the_static_simple_list() {
    ExerciseAssertions.assertAllResults(new SimpleListStaticExercise05(),
        "containsLuis=true|snapshot=[Eva#99, Ana#101, Luis#203]");
  }

}
