package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class DoublyLinkedListExercise03 extends AbstractDoublyLinkedListExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addLast("tres");
    list.addLast("cuatro");
    list.addLast("cinco");

    return ExerciseSupport.format(
        ExerciseSupport.named("first", list.get(0)),
        ExerciseSupport.named("middle", list.get(2)),
        ExerciseSupport.named("last", list.get(4)));
  }

}