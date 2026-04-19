package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class CircularSinglyLinkedListExercise04 extends AbstractCircularSinglyLinkedListExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("sol");
    list.addLast("luna");
    list.addFirst("inicio");
    list.removeFirst();
    list.addLast("estrella");
    list.addFirst("ancla");
    return ExerciseSupport.snapshot(list);
  }

}