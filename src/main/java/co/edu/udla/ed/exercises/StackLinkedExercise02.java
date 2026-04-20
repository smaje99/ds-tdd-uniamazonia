package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.LinkedStack;

public final class StackLinkedExercise02 {

  public String solveWithCustomIterator(LinkedStack<String> stack) {
    stack.push("A");
    stack.push("B");
    stack.push("C");
    return ExerciseSupport.named("pops", ExerciseSupport.snapshotWithIterator(stack));
  }

  public String solveWithJavaLoops(ArrayDeque<String> stack) {
    stack.addLast("A");
    stack.addLast("B");
    stack.addLast("C");
    return ExerciseSupport.named("pops", ExerciseSupport.stackDrainWithLoop(stack));
  }

  public String solveWithStreams(ArrayDeque<String> stack) {
    stack.addLast("A");
    stack.addLast("B");
    stack.addLast("C");
    return ExerciseSupport.named("pops", ExerciseSupport.stackDrainWithStreams(stack));
  }

}
