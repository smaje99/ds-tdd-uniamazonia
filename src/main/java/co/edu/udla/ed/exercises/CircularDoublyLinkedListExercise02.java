package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.CircularDoublyLinkedList;

public final class CircularDoublyLinkedListExercise02 {

  public String solveWithCustomIterator(CircularDoublyLinkedList<String> list) {
    list.addFirst("B");
    list.addLast("C");
    list.addFirst("A");
    list.addLast("D");
    return ExerciseSupport.format(
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithIterator(list)),
        ExerciseSupport.named("middle", list.get(2)));
  }

  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addFirst("B");
    list.addLast("C");
    list.addFirst("A");
    list.addLast("D");
    return ExerciseSupport.format(
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithLoop(list)),
        ExerciseSupport.named("middle", list.get(2)));
  }

  public String solveWithStreams(LinkedList<String> list) {
    list.addFirst("B");
    list.addLast("C");
    list.addFirst("A");
    list.addLast("D");
    return ExerciseSupport.format(
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithStreams(list)),
        ExerciseSupport.named("middle", list.get(2)));
  }

}
