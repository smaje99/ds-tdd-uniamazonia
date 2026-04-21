package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class BTreeExercise04Test {

  @Test
  void should_answer_membership_queries() {
    ExerciseAssertions.assertAllResults(new BTreeExercise04(), "contains6=true|contains99=false");
  }

}
