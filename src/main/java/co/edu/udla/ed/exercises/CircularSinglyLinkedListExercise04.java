package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.CircularSinglyLinkedList;

public final class CircularSinglyLinkedListExercise04 {

  public String solveWithCustomIterator(CircularSinglyLinkedList<String> list) {
    list.addLast("sol");
    list.addLast("luna");
    list.addFirst("inicio");
    list.removeFirst();
    list.addLast("estrella");
    list.addFirst("ancla");
    return ExerciseSupport.snapshotWithIterator(list);
  }

  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addLast("sol");
    list.addLast("luna");
    list.addFirst("inicio");
    list.removeFirst();
    list.addLast("estrella");
    list.addFirst("ancla");
    return ExerciseSupport.snapshotWithLoop(list);
  }

  public String solveWithStreams(LinkedList<String> list) {
    list.addLast("sol");
    list.addLast("luna");
    list.addFirst("inicio");
    list.removeFirst();
    list.addLast("estrella");
    list.addFirst("ancla");
    return ExerciseSupport.snapshotWithStreams(list);
  }

}
