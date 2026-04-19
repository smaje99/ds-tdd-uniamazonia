package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class SimpleListStaticExercise01 extends AbstractSimpleListStaticExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("B");
    list.addFirst("A");
    list.addLast("C");
    list.addFirst("inicio");
    return ExerciseSupport.snapshot(list);
  }

}