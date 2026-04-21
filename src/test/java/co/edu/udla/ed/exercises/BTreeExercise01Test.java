package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class BTreeExercise01Test {

  @Test
  void should_report_sorted_state() {
    ExerciseAssertions.assertAllResults(new BTreeExercise01(),
        "size=8|height=2|inOrder=[5, 6, 7, 10, 12, 17, 20, 30]");
  }

}
