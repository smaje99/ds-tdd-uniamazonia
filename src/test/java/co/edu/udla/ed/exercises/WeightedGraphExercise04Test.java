package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class WeightedGraphExercise04Test {

  @Test
  void should_compute_mst_summary() {
    ExerciseAssertions.assertAllResults(new WeightedGraphExercise04(), "edges=4|weight=10.0");
  }

}
