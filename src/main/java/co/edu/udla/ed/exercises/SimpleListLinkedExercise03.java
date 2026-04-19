package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class SimpleListLinkedExercise03 extends AbstractSimpleListLinkedExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("rojo");
    list.addLast("verde");
    list.addLast("azul");
    list.addLast("amarillo");

    return ExerciseSupport.format(
        ExerciseSupport.named("get1", list.get(1)),
        ExerciseSupport.named("get3", list.get(3)),
        ExerciseSupport.named("containsAzul", list.contains("azul")),
        ExerciseSupport.named("containsNegro", list.contains("negro")));
  }

}