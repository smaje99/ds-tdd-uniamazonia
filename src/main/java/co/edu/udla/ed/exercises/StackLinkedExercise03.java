package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.LinkedStack;

public final class StackLinkedExercise03 {

  public String solveWithCustomIterator(LinkedStack<String> stack) {
    stack.push("nodo-1");
    stack.push("nodo-2");
    String popped = stack.pop();
    stack.push("nodo-3");
    stack.push("nodo-4");
    stack.pop();
    return ExerciseSupport.format(
        ExerciseSupport.named("firstPop", popped),
        ExerciseSupport.named("peek", stack.peek()),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(stack)));
  }

  public String solveWithJavaLoops(ArrayDeque<String> stack) {
    stack.addLast("nodo-1");
    stack.addLast("nodo-2");
    String popped = stack.removeLast();
    stack.addLast("nodo-3");
    stack.addLast("nodo-4");
    stack.removeLast();
    return ExerciseSupport.format(
        ExerciseSupport.named("firstPop", popped),
        ExerciseSupport.named("peek", stack.peekLast()),
        ExerciseSupport.named("size", stack.size()));
  }

  public String solveWithStreams(ArrayDeque<String> stack) {
    stack.addLast("nodo-1");
    stack.addLast("nodo-2");
    String popped = stack.removeLast();
    stack.addLast("nodo-3");
    stack.addLast("nodo-4");
    stack.removeLast();
    return ExerciseSupport.format(
        ExerciseSupport.named("firstPop", popped),
        ExerciseSupport.named("peek", stack.peekLast()),
        ExerciseSupport.named("size", stack.stream().count()));
  }

}
