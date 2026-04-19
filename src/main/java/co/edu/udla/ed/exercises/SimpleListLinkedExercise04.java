package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class SimpleListLinkedExercise04 extends AbstractSimpleListLinkedExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addFirst("cero");
    list.removeFirst();
    list.addLast("tres");
    list.addLast("cuatro");
    list.addFirst("cabecera");
    list.addLast("cinco");

    return ExerciseSupport.snapshot(list);
  }

}