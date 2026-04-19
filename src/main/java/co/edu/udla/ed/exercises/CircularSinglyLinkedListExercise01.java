package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class CircularSinglyLinkedListExercise01 extends AbstractCircularSinglyLinkedListExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addFirst("inicio");
    return ExerciseSupport.snapshot(list);
  }

}