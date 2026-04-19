package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class SimpleListLinkedExercise01 extends AbstractSimpleListLinkedExercise {

  @Override
  protected String solve(List<String> list) {
    list.addFirst("B");
    list.addLast("C");
    list.addFirst("A");
    list.addLast("D");
    return ExerciseSupport.snapshot(list);
  }

}