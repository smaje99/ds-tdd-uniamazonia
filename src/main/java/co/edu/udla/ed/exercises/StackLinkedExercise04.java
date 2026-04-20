package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.LinkedStack;

public final class StackLinkedExercise04 {

  public String solveWithCustomIterator(LinkedStack<String> stack) {
    stack.push("primero");
    stack.push("segundo");
    stack.push("tercero");
    stack.push("cuarto");
    stack.push("quinto");
    return ExerciseSupport.named("pops", ExerciseSupport.snapshotWithIterator(stack));
  }

  public String solveWithJavaLoops(ArrayDeque<String> stack) {
    stack.addLast("primero");
    stack.addLast("segundo");
    stack.addLast("tercero");
    stack.addLast("cuarto");
    stack.addLast("quinto");
    return ExerciseSupport.named("pops", ExerciseSupport.stackDrainWithLoop(stack));
  }

  public String solveWithStreams(ArrayDeque<String> stack) {
    stack.addLast("primero");
    stack.addLast("segundo");
    stack.addLast("tercero");
    stack.addLast("cuarto");
    stack.addLast("quinto");
    return ExerciseSupport.named("pops", ExerciseSupport.stackDrainWithStreams(stack));
  }

}
