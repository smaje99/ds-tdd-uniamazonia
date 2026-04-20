package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.DoublyLinkedList;

public final class DoublyLinkedListExercise05 {

  public String solveWithCustomIterator(DoublyLinkedList<ExerciseSupport.Learner> list) {
    list.addLast(ExerciseSupport.learner("Ana", 101));
    list.addLast(ExerciseSupport.learner("Luis", 203));
    list.addLast(ExerciseSupport.learner("Mia", 305));
    return ExerciseSupport.format(
        ExerciseSupport.named("middleIsLuis", list.get(1).equals(ExerciseSupport.learner("Luis", 203))),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithIterator(list)));
  }

  public String solveWithJavaLoops(LinkedList<ExerciseSupport.Learner> list) {
    list.addLast(ExerciseSupport.learner("Ana", 101));
    list.addLast(ExerciseSupport.learner("Luis", 203));
    list.addLast(ExerciseSupport.learner("Mia", 305));
    return ExerciseSupport.format(
        ExerciseSupport.named("middleIsLuis", list.get(1).equals(ExerciseSupport.learner("Luis", 203))),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithLoop(list)));
  }

  public String solveWithStreams(LinkedList<ExerciseSupport.Learner> list) {
    list.addLast(ExerciseSupport.learner("Ana", 101));
    list.addLast(ExerciseSupport.learner("Luis", 203));
    list.addLast(ExerciseSupport.learner("Mia", 305));
    return ExerciseSupport.format(
        ExerciseSupport.named("middleIsLuis", list.get(1).equals(ExerciseSupport.learner("Luis", 203))),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithStreams(list)));
  }

}
