package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class CircularDoublyLinkedListExercise04 extends AbstractCircularDoublyLinkedListExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("base");
    list.addLast("temporal");
    list.clear();
    list.addFirst("nuevo-inicio");
    list.addLast("nuevo-final");
    list.addLast("cierre");
    return ExerciseSupport.snapshot(list);
  }

}