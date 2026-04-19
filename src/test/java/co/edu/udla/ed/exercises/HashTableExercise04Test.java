package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class HashTableExercise04Test {

  @Test
  void should_survive_collisions_and_growth() {
    ExerciseAssertions.assertAllResults(new HashTableExercise04(),
        "removed=7|size=17|getK0=0|getK17=17|containsK7=false");
  }

}