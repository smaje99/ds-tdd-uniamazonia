package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.SinglyLinkedList;

public final class SimpleListLinkedExercise05 {

  public String solveWithCustomIterator(SinglyLinkedList<ExerciseSupport.Learner> list) {
    list.addFirst(ExerciseSupport.learner("Luis", 203));
    list.addLast(ExerciseSupport.learner("Mia", 305));
    list.addFirst(ExerciseSupport.learner("Ana", 101));
    ExerciseSupport.Learner removed = list.removeLast();
    list.addLast(ExerciseSupport.learner("Leo", 404));
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("containsAna", list.contains(ExerciseSupport.learner("Ana", 101))),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithIterator(list)));
  }

  public String solveWithJavaLoops(LinkedList<ExerciseSupport.Learner> list) {
    list.addFirst(ExerciseSupport.learner("Luis", 203));
    list.addLast(ExerciseSupport.learner("Mia", 305));
    list.addFirst(ExerciseSupport.learner("Ana", 101));
    ExerciseSupport.Learner removed = list.removeLast();
    list.addLast(ExerciseSupport.learner("Leo", 404));
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
    list.addFirst(ExerciseSupport.learner("Luis", 203));
    list.addLast(ExerciseSupport.learner("Mia", 305));
    list.addFirst(ExerciseSupport.learner("Ana", 101));
    ExerciseSupport.Learner removed = list.removeLast();
    list.addLast(ExerciseSupport.learner("Leo", 404));
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("containsAna", list.stream()
            .anyMatch(ExerciseSupport.learner("Ana", 101)::equals)),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithStreams(list)));
  }

}
