package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class BTreeExercise05Test {

  @Test
  void should_clear_and_rebuild_tree() {
    ExerciseAssertions.assertAllResults(new BTreeExercise05(), "size=2|inOrder=[4, 9]");
  }

}
