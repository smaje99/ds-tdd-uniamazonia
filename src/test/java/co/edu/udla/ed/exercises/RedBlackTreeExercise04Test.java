package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class RedBlackTreeExercise04Test {

  @Test
  void should_answer_membership_queries() {
    ExerciseAssertions.assertAllResults(new RedBlackTreeExercise04(), "contains3=true|contains7=false");
  }

}
