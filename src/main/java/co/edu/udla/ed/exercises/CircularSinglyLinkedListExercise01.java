package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.CircularSinglyLinkedList;

public final class CircularSinglyLinkedListExercise01 {

  public String solveWithCustomIterator(CircularSinglyLinkedList<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addFirst("inicio");
    return ExerciseSupport.snapshotWithIterator(list);
  }

  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addFirst("inicio");
    return ExerciseSupport.snapshotWithLoop(list);
  }

  public String solveWithStreams(LinkedList<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addFirst("inicio");
    return ExerciseSupport.snapshotWithStreams(list);
  }

}
