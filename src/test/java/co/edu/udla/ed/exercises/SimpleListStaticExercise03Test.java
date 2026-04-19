package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SimpleListStaticExercise03Test {

  @Test
  void should_report_queries_and_contains_results() {
    ExerciseAssertions.assertAllResults(new SimpleListStaticExercise03(),
        "get0=casa|get2=gato|containsPerro=true|containsLoro=false");
  }

}