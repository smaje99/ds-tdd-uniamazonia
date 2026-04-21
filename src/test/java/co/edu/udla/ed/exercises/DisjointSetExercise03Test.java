package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class DisjointSetExercise03Test {

  @Test
  void should_merge_components_transitively() {
    ExerciseAssertions.assertAllResults(new DisjointSetExercise03(), "repA=A|repD=A|connected=true");
  }

}
