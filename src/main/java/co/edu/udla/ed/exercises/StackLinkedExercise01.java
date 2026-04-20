package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.LinkedStack;

public final class StackLinkedExercise01 {

  public String solveWithCustomIterator(LinkedStack<String> stack) {
    stack.push("rojo");
    stack.push("verde");
    stack.push("azul");
    return ExerciseSupport.format(
        ExerciseSupport.named("peek", stack.peek()),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(stack)));
  }

  public String solveWithJavaLoops(ArrayDeque<String> stack) {
    stack.addLast("rojo");
    stack.addLast("verde");
    stack.addLast("azul");
    return ExerciseSupport.format(
        ExerciseSupport.named("peek", stack.peekLast()),
        ExerciseSupport.named("size", stack.size()));
  }

  public String solveWithStreams(ArrayDeque<String> stack) {
    stack.addLast("rojo");
    stack.addLast("verde");
    stack.addLast("azul");
    return ExerciseSupport.format(
        ExerciseSupport.named("peek", stack.peekLast()),
        ExerciseSupport.named("size", stack.stream().count()));
  }

}
