package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.LinkedStack;

public final class StackLinkedExercise05 {

  public String solveWithCustomIterator(LinkedStack<ExerciseSupport.Learner> stack) {
    stack.push(ExerciseSupport.learner("Eva", 99));
    stack.push(ExerciseSupport.learner("Ana", 101));
    stack.push(ExerciseSupport.learner("Luis", 203));
    stack.pop();
    stack.push(ExerciseSupport.learner("Mia", 305));
    return ExerciseSupport.format(
        ExerciseSupport.named("peekIsMia", stack.peek().equals(ExerciseSupport.learner("Mia", 305))),
        ExerciseSupport.named("drain", ExerciseSupport.snapshotWithIterator(stack)));
  }

  public String solveWithJavaLoops(ArrayDeque<ExerciseSupport.Learner> stack) {
    stack.addLast(ExerciseSupport.learner("Eva", 99));
    stack.addLast(ExerciseSupport.learner("Ana", 101));
    stack.addLast(ExerciseSupport.learner("Luis", 203));
    stack.removeLast();
    stack.addLast(ExerciseSupport.learner("Mia", 305));
    return ExerciseSupport.format(
        ExerciseSupport.named("peekIsMia", stack.peekLast().equals(ExerciseSupport.learner("Mia", 305))),
        ExerciseSupport.named("drain", ExerciseSupport.stackDrainWithLoop(stack)));
  }

  public String solveWithStreams(ArrayDeque<ExerciseSupport.Learner> stack) {
    stack.addLast(ExerciseSupport.learner("Eva", 99));
    stack.addLast(ExerciseSupport.learner("Ana", 101));
    stack.addLast(ExerciseSupport.learner("Luis", 203));
    stack.removeLast();
    stack.addLast(ExerciseSupport.learner("Mia", 305));
    return ExerciseSupport.format(
        ExerciseSupport.named("peekIsMia", stack.peekLast().equals(ExerciseSupport.learner("Mia", 305))),
        ExerciseSupport.named("drain", ExerciseSupport.stackDrainWithStreams(stack)));
  }

}
