package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class DirectedAdjacencyListGraphExercise01Test {

  @Test
  void should_report_directed_counts() {
    ExerciseAssertions.assertAllResults(new DirectedAdjacencyListGraphExercise01(), "vertices=4|edges=4|BtoA=false");
  }

}
