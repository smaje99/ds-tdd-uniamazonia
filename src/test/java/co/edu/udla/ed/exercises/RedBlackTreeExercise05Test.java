package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class RedBlackTreeExercise05Test {

  @Test
  void should_clear_and_rebuild_tree() {
    ExerciseAssertions.assertAllResults(new RedBlackTreeExercise05(), "size=2|inOrder=[4, 9]");
  }

}
