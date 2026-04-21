package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class OpenAddressingHashTableExercise05Test {

  @Test
  void should_clear_and_rebuild_table() {
    ExerciseAssertions.assertAllResults(new OpenAddressingHashTableExercise05(), "size=2|getC=30|getD=40");
  }

}
