package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SimpleListLinkedExercise01Test {

  @Test
  void should_mix_head_and_tail_insertions() {
    ExerciseAssertions.assertAllResults(new SimpleListLinkedExercise01(), "[A, B, C, D]");
  }

}