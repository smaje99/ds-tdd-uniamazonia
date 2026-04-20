package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.CircularDoublyLinkedList;

public final class CircularDoublyLinkedListExercise05 {

  public String solveWithCustomIterator(CircularDoublyLinkedList<ExerciseSupport.Learner> list) {
    list.addLast(ExerciseSupport.learner("Ana", 101));
    list.addLast(ExerciseSupport.learner("Luis", 203));
    list.addFirst(ExerciseSupport.learner("Eva", 99));
    ExerciseSupport.Learner removed = list.removeLast();
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("containsAna", list.contains(ExerciseSupport.learner("Ana", 101))),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithIterator(list)));
  }

  public String solveWithJavaLoops(LinkedList<ExerciseSupport.Learner> list) {
    list.addLast(ExerciseSupport.learner("Ana", 101));
    list.addLast(ExerciseSupport.learner("Luis", 203));
    list.addFirst(ExerciseSupport.learner("Eva", 99));
    ExerciseSupport.Learner removed = list.removeLast();
    boolean containsAna = false;
    for (ExerciseSupport.Learner learner : list) {
      if (learner.equals(ExerciseSupport.learner("Ana", 101))) {
        containsAna = true;
        break;
      }
    }
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("containsAna", containsAna),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithLoop(list)));
  }

  public String solveWithStreams(LinkedList<ExerciseSupport.Learner> list) {
    list.addLast(ExerciseSupport.learner("Ana", 101));
    list.addLast(ExerciseSupport.learner("Luis", 203));
    list.addFirst(ExerciseSupport.learner("Eva", 99));
    ExerciseSupport.Learner removed = list.removeLast();
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("containsAna", list.stream()
            .anyMatch(ExerciseSupport.learner("Ana", 101)::equals)),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithStreams(list)));
  }

}
