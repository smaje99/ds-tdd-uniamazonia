package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class BTreeExercise02Test {

  @Test
  void should_ignore_duplicate_values() {
    ExerciseAssertions.assertAllResults(new BTreeExercise02(), "size=1|height=1|inOrder=[4]");
  }

}
