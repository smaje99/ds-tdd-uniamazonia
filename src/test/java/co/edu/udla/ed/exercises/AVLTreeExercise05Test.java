package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class AVLTreeExercise05Test {

  @Test
  void should_use_domain_objects_in_the_avl_tree() {
    ExerciseAssertions.assertAllResults(new AVLTreeExercise05(),
        "containsEva=true|height=3|inOrder=[Ian@10, Ana@20, Eva@30, Luis@40, Zoe@60]");
  }

}
