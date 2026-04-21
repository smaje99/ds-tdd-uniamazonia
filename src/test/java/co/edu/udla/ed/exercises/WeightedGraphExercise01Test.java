package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class WeightedGraphExercise01Test {

  @Test
  void should_report_weighted_counts() {
    ExerciseAssertions.assertAllResults(new WeightedGraphExercise01(), "vertices=3|edges=2|AB=4.0");
  }

}
