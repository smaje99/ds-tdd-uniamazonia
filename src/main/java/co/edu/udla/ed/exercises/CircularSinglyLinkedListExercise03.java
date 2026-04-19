package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class CircularSinglyLinkedListExercise03 extends AbstractCircularSinglyLinkedListExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addLast("C");

    java.util.List<String> removed = new java.util.ArrayList<>();
    removed.add(list.removeFirst());
    removed.add(list.removeLast());
    removed.add(list.removeFirst());

    list.addLast("reinicio");

    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshot(list)));
  }

}