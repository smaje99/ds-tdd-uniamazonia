package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class HashTableExercise02Test {

  @Test
  void should_overwrite_a_key_without_growing() {
    ExerciseAssertions.assertAllResults(new HashTableExercise02(),
        "previous=10|size=1|getA=99");
  }

}