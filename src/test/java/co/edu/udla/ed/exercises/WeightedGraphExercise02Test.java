package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class WeightedGraphExercise02Test {

  @Test
  void should_compute_dijkstra_distances() {
    ExerciseAssertions.assertAllResults(new WeightedGraphExercise02(), "A=0.0|B=3.0|C=2.0|D=8.0|E=10.0");
  }

}
