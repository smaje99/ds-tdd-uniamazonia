package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class QueueLinkedExercise01Test {

  @Test
  void should_report_the_front_value() {
    ExerciseAssertions.assertAllResults(new QueueLinkedExercise01(),
        "peek=primero|size=3");
  }

}