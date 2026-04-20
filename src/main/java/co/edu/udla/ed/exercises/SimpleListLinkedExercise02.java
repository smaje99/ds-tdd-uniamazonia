package co.edu.udla.ed.exercises;

import java.util.ArrayList;
import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.SinglyLinkedList;

public final class SimpleListLinkedExercise02 {

  public String solveWithCustomIterator(SinglyLinkedList<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addLast("C");
    list.addLast("D");
    list.addLast("E");
    java.util.List<String> removed = new ArrayList<>();
    removed.add(list.removeFirst());
    removed.add(list.removeLast());
    removed.add(list.removeFirst());
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithIterator(list)));
  }

  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addLast("C");
    list.addLast("D");
    list.addLast("E");
    java.util.List<String> removed = new ArrayList<>();
    removed.add(list.removeFirst());
    removed.add(list.removeLast());
    removed.add(list.removeFirst());
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithLoop(list)));
  }

  public String solveWithStreams(LinkedList<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addLast("C");
    list.addLast("D");
    list.addLast("E");
    java.util.List<String> removed = new ArrayList<>();
    removed.add(list.removeFirst());
    removed.add(list.removeLast());
    removed.add(list.removeFirst());
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithStreams(list)));
  }

}
