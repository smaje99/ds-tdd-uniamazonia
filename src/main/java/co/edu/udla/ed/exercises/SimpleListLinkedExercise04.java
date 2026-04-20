package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.SinglyLinkedList;

public final class SimpleListLinkedExercise04 {

  public String solveWithCustomIterator(SinglyLinkedList<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addFirst("cero");
    list.removeFirst();
    list.addLast("tres");
    list.addLast("cuatro");
    list.addFirst("cabecera");
    list.addLast("cinco");
    return ExerciseSupport.snapshotWithIterator(list);
  }

  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addFirst("cero");
    list.removeFirst();
    list.addLast("tres");
    list.addLast("cuatro");
    list.addFirst("cabecera");
    list.addLast("cinco");
    return ExerciseSupport.snapshotWithLoop(list);
  }

  public String solveWithStreams(LinkedList<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addFirst("cero");
    list.removeFirst();
    list.addLast("tres");
    list.addLast("cuatro");
    list.addFirst("cabecera");
    list.addLast("cinco");
    return ExerciseSupport.snapshotWithStreams(list);
  }

}
