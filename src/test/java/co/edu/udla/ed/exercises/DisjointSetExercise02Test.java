package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class DisjointSetExercise02Test {

  @Test
  void should_merge_one_pair_and_report_connectivity() {
    ExerciseAssertions.assertAllResults(new DisjointSetExercise02(), "sets=2|AB=true|AC=false");
  }

}
