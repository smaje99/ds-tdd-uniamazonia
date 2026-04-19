package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class HashTableExercise01Test {

  @Test
  void should_store_and_retrieve_basic_pairs() {
    ExerciseAssertions.assertAllResults(new HashTableExercise01(),
        "size=2|getA=10|getB=20");
  }

}