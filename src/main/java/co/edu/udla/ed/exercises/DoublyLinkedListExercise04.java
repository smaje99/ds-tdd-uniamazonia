package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.DoublyLinkedList;

public final class DoublyLinkedListExercise04 {

  public String solveWithCustomIterator(DoublyLinkedList<String> list) {
    list.addLast("base-1");
    list.addLast("base-2");
    list.clear();
    list.addLast("nuevo-1");
    list.addLast("nuevo-2");
    list.addFirst("nuevo-0");
    return ExerciseSupport.snapshotWithIterator(list);
  }

  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addLast("base-1");
    list.addLast("base-2");
    list.clear();
    list.addLast("nuevo-1");
    list.addLast("nuevo-2");
    list.addFirst("nuevo-0");
    return ExerciseSupport.snapshotWithLoop(list);
  }

  public String solveWithStreams(LinkedList<String> list) {
    list.addLast("base-1");
    list.addLast("base-2");
    list.clear();
    list.addLast("nuevo-1");
    list.addLast("nuevo-2");
    list.addFirst("nuevo-0");
    return ExerciseSupport.snapshotWithStreams(list);
  }

}
