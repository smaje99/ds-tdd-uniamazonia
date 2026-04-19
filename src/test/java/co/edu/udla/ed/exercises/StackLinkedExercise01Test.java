package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class StackLinkedExercise01Test {

  @Test
  void should_report_the_current_top() {
    ExerciseAssertions.assertAllResults(new StackLinkedExercise01(), "peek=azul|size=3");
  }

}