package co.edu.udla.ed.exercises;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

final class ExerciseAssertions {

  private ExerciseAssertions() {
  }

  static void assertAllResults(ExerciseCase exercise, String expected) {
    assertThat(exercise.solveWithScratch())
        .as("scratch debe entregar la retroalimentación esperada")
        .isEqualTo(expected);
    assertThat(exercise.solveWithLinear())
        .as("linear debe entregar la retroalimentación esperada")
        .isEqualTo(expected);
    assertThat(exercise.solveWithCollections())
        .as("collections debe entregar la retroalimentación esperada")
        .isEqualTo(expected);
  }

  static void assertAllThrow(ExerciseCase exercise, Class<? extends Throwable> type) {
    assertThatThrownBy(exercise::solveWithScratch)
        .as("scratch debe lanzar la excepción esperada")
        .isInstanceOf(type);
    assertThatThrownBy(exercise::solveWithLinear)
        .as("linear debe lanzar la excepción esperada")
        .isInstanceOf(type);
    assertThatThrownBy(exercise::solveWithCollections)
        .as("collections debe lanzar la excepción esperada")
        .isInstanceOf(type);
  }

}
