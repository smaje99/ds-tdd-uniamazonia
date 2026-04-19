package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class SimpleListLinkedExercise02 extends AbstractSimpleListLinkedExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addLast("C");
    list.addLast("D");
    list.addLast("E");

    java.util.List<String> removed = new java.util.ArrayList<>();
    removed.add(list.removeFirst());
    removed.add(list.removeLast());
    removed.add(list.removeFirst());

    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshot(list)));
  }

}