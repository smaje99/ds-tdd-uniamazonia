package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class CircularDoublyLinkedListExercise01 extends AbstractCircularDoublyLinkedListExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addLast("tres");
    return ExerciseSupport.snapshot(list);
  }

}