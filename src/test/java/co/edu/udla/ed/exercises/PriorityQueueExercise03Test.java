package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class PriorityQueueExercise03Test {

  @Test
  void should_keep_duplicate_priorities() {
    ExerciseAssertions.assertAllResults(new PriorityQueueExercise03(), "removed=2|remaining=[2, 4, 4]");
  }

}
