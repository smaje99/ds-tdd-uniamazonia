package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class HashTableExercise05Test {

  @Test
  void should_use_domain_objects_in_the_hash_table() {
    ExerciseAssertions.assertAllResults(new HashTableExercise05(),
        "previous=Luis#203|size=2|getMAT=Eva#99|removedFIS=Mia#305|containsEDA=true");
  }

}
