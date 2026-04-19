package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

/**
 * Guided exercise 02 for the array-backed simple-list series.
 *
 * <p>This scenario removes both logical extremes and reports the removed values together with the remaining order. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class SimpleListStaticExercise02 extends AbstractSimpleListStaticExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addLast("tres");
    list.addLast("cuatro");

    String removedFirst = list.removeFirst();
    String removedLast = list.removeLast();

    return ExerciseSupport.format(
        ExerciseSupport.named("removedFirst", removedFirst),
        ExerciseSupport.named("removedLast", removedLast),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshot(list)));
  }

}