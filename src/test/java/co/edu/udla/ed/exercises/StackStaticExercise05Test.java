package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class StackStaticExercise05Test {

  @Test
  void should_use_domain_objects_in_the_static_stack() {
    ExerciseAssertions.assertAllResults(new StackStaticExercise05(),
        "topMatches=true|popped=Mia#305|remaining=[Luis#203, Ana#101]");
  }

}
