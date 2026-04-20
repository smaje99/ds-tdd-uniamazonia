package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.StaticStack;

public final class StackStaticExercise05 {

  public String solveWithCustomIterator(StaticStack<ExerciseSupport.Learner> stack) {
    stack.push(ExerciseSupport.learner("Ana", 101));
    stack.push(ExerciseSupport.learner("Luis", 203));
    stack.push(ExerciseSupport.learner("Mia", 305));
    boolean topMatches = stack.peek().equals(ExerciseSupport.learner("Mia", 305));
    ExerciseSupport.Learner popped = stack.pop();
    return ExerciseSupport.format(
        ExerciseSupport.named("topMatches", topMatches),
        ExerciseSupport.named("popped", popped),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithIterator(stack)));
  }

  public String solveWithJavaLoops(ArrayDeque<ExerciseSupport.Learner> stack) {
    stack.addLast(ExerciseSupport.learner("Ana", 101));
    stack.addLast(ExerciseSupport.learner("Luis", 203));
    stack.addLast(ExerciseSupport.learner("Mia", 305));
    boolean topMatches = stack.peekLast().equals(ExerciseSupport.learner("Mia", 305));
    ExerciseSupport.Learner popped = stack.removeLast();
    return ExerciseSupport.format(
        ExerciseSupport.named("topMatches", topMatches),
        ExerciseSupport.named("popped", popped),
        ExerciseSupport.named("remaining", ExerciseSupport.stackDrainWithLoop(stack)));
  }

  public String solveWithStreams(ArrayDeque<ExerciseSupport.Learner> stack) {
    stack.addLast(ExerciseSupport.learner("Ana", 101));
    stack.addLast(ExerciseSupport.learner("Luis", 203));
    stack.addLast(ExerciseSupport.learner("Mia", 305));
    boolean topMatches = stack.peekLast().equals(ExerciseSupport.learner("Mia", 305));
    ExerciseSupport.Learner popped = stack.removeLast();
    return ExerciseSupport.format(
        ExerciseSupport.named("topMatches", topMatches),
        ExerciseSupport.named("popped", popped),
        ExerciseSupport.named("remaining", ExerciseSupport.stackDrainWithStreams(stack)));
  }

}
