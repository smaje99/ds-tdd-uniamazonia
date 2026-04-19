package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class HashTableExercise03Test {

  @Test
  void should_remove_entries_and_clear_the_table() {
    ExerciseAssertions.assertAllResults(new HashTableExercise03(),
        "removedA=10|containsA=false|sizeBeforeClear=1|emptyAfterClear=true");
  }

}