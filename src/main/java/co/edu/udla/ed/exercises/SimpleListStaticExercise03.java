package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class SimpleListStaticExercise03 extends AbstractSimpleListStaticExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("casa");
    list.addLast("perro");
    list.addLast("gato");
    list.addLast("pez");

    return ExerciseSupport.format(
        ExerciseSupport.named("get0", list.get(0)),
        ExerciseSupport.named("get2", list.get(2)),
        ExerciseSupport.named("containsPerro", list.contains("perro")),
        ExerciseSupport.named("containsLoro", list.contains("loro")));
  }

}