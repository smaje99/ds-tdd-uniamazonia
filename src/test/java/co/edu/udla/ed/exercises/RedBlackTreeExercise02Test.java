package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class RedBlackTreeExercise02Test {

  @Test
  void should_ignore_duplicate_values() {
    ExerciseAssertions.assertAllResults(new RedBlackTreeExercise02(), "size=1|height=1|inOrder=[5]");
  }

}
