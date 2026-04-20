package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.CircularDoublyLinkedList;

public final class CircularDoublyLinkedListExercise01 {

  public String solveWithCustomIterator(CircularDoublyLinkedList<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addLast("tres");
    return ExerciseSupport.snapshotWithIterator(list);
  }

  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addLast("tres");
    return ExerciseSupport.snapshotWithLoop(list);
  }

  public String solveWithStreams(LinkedList<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addLast("tres");
    return ExerciseSupport.snapshotWithStreams(list);
  }

}
