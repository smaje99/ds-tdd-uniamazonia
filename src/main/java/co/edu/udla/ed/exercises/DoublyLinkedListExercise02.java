package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class DoublyLinkedListExercise02 extends AbstractDoublyLinkedListExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addLast("C");
    list.addLast("D");

    String removedFirst = list.removeFirst();
    String removedLast = list.removeLast();

    return ExerciseSupport.format(
        ExerciseSupport.named("removedFirst", removedFirst),
        ExerciseSupport.named("removedLast", removedLast),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshot(list)));
  }

}