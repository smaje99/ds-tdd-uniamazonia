package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeExercise02Test {

  @Test
  void should_report_contains_and_size() {
    ExerciseAssertions.assertAllResults(new BinarySearchTreeExercise02(),
        "contains3=true|contains7=false|size=5");
  }

}