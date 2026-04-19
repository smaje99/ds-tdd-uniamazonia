package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeExercise05Test {

  @Test
  void should_use_domain_objects_in_the_binary_search_tree() {
    ExerciseAssertions.assertAllResults(new BinarySearchTreeExercise05(),
        "containsEva=true|size=4|inOrder=[Ana@20, Eva@30, Luis@40, Mia@60]");
  }

}
