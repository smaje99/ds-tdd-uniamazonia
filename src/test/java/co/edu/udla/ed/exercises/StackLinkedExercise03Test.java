package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class StackLinkedExercise03Test {

  @Test
  void should_track_interleaved_pushes_and_pops() {
    ExerciseAssertions.assertAllResults(new StackLinkedExercise03(),
        "firstPop=nodo-2|peek=nodo-3|size=2");
  }

}