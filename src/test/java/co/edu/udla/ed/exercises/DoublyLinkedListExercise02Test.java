package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class DoublyLinkedListExercise02Test {

  @Test
  void should_trim_the_first_and_last_values() {
    ExerciseAssertions.assertAllResults(new DoublyLinkedListExercise02(),
        "removedFirst=A|removedLast=D|remaining=[B, C]");
  }

}