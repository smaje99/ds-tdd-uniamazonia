package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SimpleListStaticExercise04Test {

  @Test
  void should_preserve_order_after_a_long_mixed_sequence() {
    ExerciseAssertions.assertAllResults(new SimpleListStaticExercise04(),
        "[inicio-2, inicio-1, A, B, C, D, E, F, G, H, I, J, K]");
  }

}