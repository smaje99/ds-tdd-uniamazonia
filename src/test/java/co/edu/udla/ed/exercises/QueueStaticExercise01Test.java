package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class QueueStaticExercise01Test {

  @Test
  void should_report_front_and_size() {
    ExerciseAssertions.assertAllResults(new QueueStaticExercise01(), "peek=A|size=3");
  }

}