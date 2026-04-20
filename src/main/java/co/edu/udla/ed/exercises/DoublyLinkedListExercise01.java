package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.DoublyLinkedList;

public final class DoublyLinkedListExercise01 {

  public String solveWithCustomIterator(DoublyLinkedList<String> list) {
    list.addLast("lunes");
    list.addLast("martes");
    list.addLast("miércoles");
    list.addLast("jueves");
    return ExerciseSupport.snapshotWithIterator(list);
  }

  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addLast("lunes");
    list.addLast("martes");
    list.addLast("miércoles");
    list.addLast("jueves");
    return ExerciseSupport.snapshotWithLoop(list);
  }

  public String solveWithStreams(LinkedList<String> list) {
    list.addLast("lunes");
    list.addLast("martes");
    list.addLast("miércoles");
    list.addLast("jueves");
    return ExerciseSupport.snapshotWithStreams(list);
  }

}
