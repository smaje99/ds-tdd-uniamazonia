package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class DoublyLinkedListExercise01 extends AbstractDoublyLinkedListExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("lunes");
    list.addLast("martes");
    list.addLast("miércoles");
    list.addLast("jueves");
    return ExerciseSupport.snapshot(list);
  }

}