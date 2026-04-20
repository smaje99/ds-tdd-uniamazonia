package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.DoublyLinkedList;

public final class DoublyLinkedListExercise03 {

  public String solveWithCustomIterator(DoublyLinkedList<String> list) {
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

  public String solveWithJavaLoops(LinkedList<String> list) {
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

  public String solveWithStreams(LinkedList<String> list) {
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
