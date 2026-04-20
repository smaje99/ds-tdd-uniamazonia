package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.SinglyLinkedList;

public final class SimpleListLinkedExercise03 {

  public String solveWithCustomIterator(SinglyLinkedList<String> list) {
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

  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addLast("rojo");
    list.addLast("verde");
    list.addLast("azul");
    list.addLast("amarillo");
    boolean containsAzul = false;
    boolean containsNegro = false;
    for (int i = 0; i < list.size(); i++) {
      String value = list.get(i);
      if ("azul".equals(value)) {
        containsAzul = true;
      }
      if ("negro".equals(value)) {
        containsNegro = true;
      }
    }
    return ExerciseSupport.format(
        ExerciseSupport.named("get1", list.get(1)),
        ExerciseSupport.named("get3", list.get(3)),
        ExerciseSupport.named("containsAzul", containsAzul),
        ExerciseSupport.named("containsNegro", containsNegro));
  }

  public String solveWithStreams(LinkedList<String> list) {
    list.addLast("rojo");
    list.addLast("verde");
    list.addLast("azul");
    list.addLast("amarillo");
    return ExerciseSupport.format(
        ExerciseSupport.named("get1", list.get(1)),
        ExerciseSupport.named("get3", list.get(3)),
        ExerciseSupport.named("containsAzul", list.stream().anyMatch("azul"::equals)),
        ExerciseSupport.named("containsNegro", list.stream().anyMatch("negro"::equals)));
  }

}
