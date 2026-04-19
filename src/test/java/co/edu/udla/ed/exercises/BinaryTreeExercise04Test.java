package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class BinaryTreeExercise04Test {

  @Test
  void should_fail_when_attaching_twice_on_the_same_side() {
    ExerciseAssertions.assertAllThrow(new BinaryTreeExercise04(), IllegalStateException.class);
  }

}