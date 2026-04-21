package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class DisjointSetExercise05Test {

  @Test
  void should_clear_and_rebuild_partition() {
    ExerciseAssertions.assertAllResults(new DisjointSetExercise05(), "size=2|sets=1|connected=true");
  }

}
