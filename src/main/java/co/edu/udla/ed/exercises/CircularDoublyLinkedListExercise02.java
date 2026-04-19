package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class CircularDoublyLinkedListExercise02 extends AbstractCircularDoublyLinkedListExercise {

  @Override
  protected String solve(List<String> list) {
    list.addFirst("B");
    list.addLast("C");
    list.addFirst("A");
    list.addLast("D");
    return ExerciseSupport.format(
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshot(list)),
        ExerciseSupport.named("middle", list.get(2)));
  }

}