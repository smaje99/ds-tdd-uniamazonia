package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class QueueStaticExercise03Test {

  @Test
  void should_keep_the_correct_front_after_interleaving() {
    ExerciseAssertions.assertAllResults(new QueueStaticExercise03(),
        "firstOut=A|peek=B|size=3");
  }

}