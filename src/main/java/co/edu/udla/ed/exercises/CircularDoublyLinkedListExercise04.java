package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.CircularDoublyLinkedList;

public final class CircularDoublyLinkedListExercise04 {

  public String solveWithCustomIterator(CircularDoublyLinkedList<String> list) {
    list.addLast("base");
    list.addLast("temporal");
    list.clear();
    list.addFirst("nuevo-inicio");
    list.addLast("nuevo-final");
    list.addLast("cierre");
    return ExerciseSupport.snapshotWithIterator(list);
  }

  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addLast("base");
    list.addLast("temporal");
    list.clear();
    list.addFirst("nuevo-inicio");
    list.addLast("nuevo-final");
    list.addLast("cierre");
    return ExerciseSupport.snapshotWithLoop(list);
  }

  public String solveWithStreams(LinkedList<String> list) {
    list.addLast("base");
    list.addLast("temporal");
    list.clear();
    list.addFirst("nuevo-inicio");
    list.addLast("nuevo-final");
    list.addLast("cierre");
    return ExerciseSupport.snapshotWithStreams(list);
  }

}
