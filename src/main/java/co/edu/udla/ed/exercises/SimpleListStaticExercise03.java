package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.impl.scratch.StaticSimpleList;

public final class SimpleListStaticExercise03 {

  public String solveWithCustomIterator(StaticSimpleList<String> list) {
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

  public String solveWithJavaLoops(ArrayList<String> list) {
    list.add("casa");
    list.add("perro");
    list.add("gato");
    list.add("pez");
    boolean containsPerro = false;
    boolean containsLoro = false;
    for (int i = 0; i < list.size(); i++) {
      String value = list.get(i);
      if ("perro".equals(value)) {
        containsPerro = true;
      }
      if ("loro".equals(value)) {
        containsLoro = true;
      }
    }
    return ExerciseSupport.format(
        ExerciseSupport.named("get0", list.get(0)),
        ExerciseSupport.named("get2", list.get(2)),
        ExerciseSupport.named("containsPerro", containsPerro),
        ExerciseSupport.named("containsLoro", containsLoro));
  }

  public String solveWithStreams(ArrayList<String> list) {
    list.add("casa");
    list.add("perro");
    list.add("gato");
    list.add("pez");
    return ExerciseSupport.format(
        ExerciseSupport.named("get0", list.get(0)),
        ExerciseSupport.named("get2", list.get(2)),
        ExerciseSupport.named("containsPerro", list.stream().anyMatch("perro"::equals)),
        ExerciseSupport.named("containsLoro", list.stream().anyMatch("loro"::equals)));
  }

}
