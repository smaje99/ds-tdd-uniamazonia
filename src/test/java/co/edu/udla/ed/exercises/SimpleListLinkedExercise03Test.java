package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SimpleListLinkedExercise03Test {

  @Test
  void should_expose_index_and_membership_feedback() {
    ExerciseAssertions.assertAllResults(new SimpleListLinkedExercise03(),
        "get1=verde|get3=amarillo|containsAzul=true|containsNegro=false");
  }

}