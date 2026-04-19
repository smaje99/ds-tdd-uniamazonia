package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class StackStaticExercise01Test {

  @Test
  void should_report_top_and_size() {
    ExerciseAssertions.assertAllResults(new StackStaticExercise01(), "peek=C|size=3");
  }

}