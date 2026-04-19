package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class DoublyLinkedListExercise04 extends AbstractDoublyLinkedListExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("base-1");
    list.addLast("base-2");
    list.clear();
    list.addLast("nuevo-1");
    list.addLast("nuevo-2");
    list.addFirst("nuevo-0");
    return ExerciseSupport.snapshot(list);
  }

}