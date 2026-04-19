package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class CircularSinglyLinkedListExercise02 extends AbstractCircularSinglyLinkedListExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("B");
    list.addFirst("A");
    list.addLast("C");
    list.addFirst("inicio");
    list.addLast("D");
    return ExerciseSupport.snapshot(list);
  }

}