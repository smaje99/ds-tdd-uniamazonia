package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class SimpleListStaticExercise02Test {

  @Test
  void should_remove_both_extremes_and_keep_the_middle() {
    ExerciseAssertions.assertAllResults(new SimpleListStaticExercise02(),
        "removedFirst=uno|removedLast=cuatro|remaining=[dos, tres]");
  }

}