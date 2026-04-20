package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.CircularSinglyLinkedList;

public final class CircularSinglyLinkedListExercise05 {

  public String solveWithCustomIterator(CircularSinglyLinkedList<ExerciseSupport.Learner> list) {
    list.addLast(ExerciseSupport.learner("Ana", 101));
    list.addFirst(ExerciseSupport.learner("Luis", 203));
    list.addLast(ExerciseSupport.learner("Mia", 305));
    ExerciseSupport.Learner removed = list.removeFirst();
    list.addFirst(ExerciseSupport.learner("Eva", 99));
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithIterator(list)));
  }

  public String solveWithJavaLoops(LinkedList<ExerciseSupport.Learner> list) {
    list.addLast(ExerciseSupport.learner("Ana", 101));
    list.addFirst(ExerciseSupport.learner("Luis", 203));
    list.addLast(ExerciseSupport.learner("Mia", 305));
    ExerciseSupport.Learner removed = list.removeFirst();
    list.addFirst(ExerciseSupport.learner("Eva", 99));
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithLoop(list)));
  }

  public String solveWithStreams(LinkedList<ExerciseSupport.Learner> list) {
    list.addLast(ExerciseSupport.learner("Ana", 101));
    list.addFirst(ExerciseSupport.learner("Luis", 203));
    list.addLast(ExerciseSupport.learner("Mia", 305));
    ExerciseSupport.Learner removed = list.removeFirst();
    list.addFirst(ExerciseSupport.learner("Eva", 99));
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithStreams(list)));
  }

}
