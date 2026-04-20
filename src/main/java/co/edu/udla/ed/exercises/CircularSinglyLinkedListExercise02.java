package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.CircularSinglyLinkedList;

public final class CircularSinglyLinkedListExercise02 {

  public String solveWithCustomIterator(CircularSinglyLinkedList<String> list) {
    list.addLast("B");
    list.addFirst("A");
    list.addLast("C");
    list.addFirst("inicio");
    list.addLast("D");
    return ExerciseSupport.snapshotWithIterator(list);
  }

  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addLast("B");
    list.addFirst("A");
    list.addLast("C");
    list.addFirst("inicio");
    list.addLast("D");
    return ExerciseSupport.snapshotWithLoop(list);
  }

  public String solveWithStreams(LinkedList<String> list) {
    list.addLast("B");
    list.addFirst("A");
    list.addLast("C");
    list.addFirst("inicio");
    list.addLast("D");
    return ExerciseSupport.snapshotWithStreams(list);
  }

}
