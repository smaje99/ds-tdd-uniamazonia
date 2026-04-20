package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.StaticStack;

public final class StackStaticExercise03 {

  public String solveWithCustomIterator(StaticStack<String> stack) {
    stack.push("A");
    stack.push("B");
    String popped = stack.pop();
    stack.push("C");
    return ExerciseSupport.format(
        ExerciseSupport.named("popped", popped),
        ExerciseSupport.named("peek", stack.peek()),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(stack)));
  }

  public String solveWithJavaLoops(ArrayDeque<String> stack) {
    stack.addLast("A");
    stack.addLast("B");
    String popped = stack.removeLast();
    stack.addLast("C");
    return ExerciseSupport.format(
        ExerciseSupport.named("popped", popped),
        ExerciseSupport.named("peek", stack.peekLast()),
        ExerciseSupport.named("size", stack.size()));
  }

  public String solveWithStreams(ArrayDeque<String> stack) {
    stack.addLast("A");
    stack.addLast("B");
    String popped = stack.removeLast();
    stack.addLast("C");
    return ExerciseSupport.format(
        ExerciseSupport.named("popped", popped),
        ExerciseSupport.named("peek", stack.peekLast()),
        ExerciseSupport.named("size", stack.stream().count()));
  }

}
