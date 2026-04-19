package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

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