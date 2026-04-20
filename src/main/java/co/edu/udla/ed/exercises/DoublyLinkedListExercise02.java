package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.DoublyLinkedList;

public final class DoublyLinkedListExercise02 {

  public String solveWithCustomIterator(DoublyLinkedList<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addLast("C");
    list.addLast("D");
    String removedFirst = list.removeFirst();
    String removedLast = list.removeLast();
    return ExerciseSupport.format(
        ExerciseSupport.named("removedFirst", removedFirst),
        ExerciseSupport.named("removedLast", removedLast),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithIterator(list)));
  }

  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addLast("C");
    list.addLast("D");
    String removedFirst = list.removeFirst();
    String removedLast = list.removeLast();
    return ExerciseSupport.format(
        ExerciseSupport.named("removedFirst", removedFirst),
        ExerciseSupport.named("removedLast", removedLast),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithLoop(list)));
  }

  public String solveWithStreams(LinkedList<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addLast("C");
    list.addLast("D");
    String removedFirst = list.removeFirst();
    String removedLast = list.removeLast();
    return ExerciseSupport.format(
        ExerciseSupport.named("removedFirst", removedFirst),
        ExerciseSupport.named("removedLast", removedLast),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithStreams(list)));
  }

}
