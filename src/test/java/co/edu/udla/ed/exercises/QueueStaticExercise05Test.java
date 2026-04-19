package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class QueueStaticExercise05Test {

  @Test
  void should_use_domain_objects_in_the_static_queue() {
    ExerciseAssertions.assertAllResults(new QueueStaticExercise05(),
        "frontMatches=true|served=Ana#101|remaining=[Luis#203, Mia#305]");
  }

}
