package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class StackStaticExercise03Test {

  @Test
  void should_keep_consistent_state_after_interleaving_operations() {
    ExerciseAssertions.assertAllResults(new StackStaticExercise03(), "popped=B|peek=C|size=2");
  }

}