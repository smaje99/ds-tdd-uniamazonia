package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Stack;

public final class StackLinkedExercise03 extends AbstractStackLinkedExercise {

  @Override
  protected String solve(Stack<String> stack) {
    stack.push("nodo-1");
    stack.push("nodo-2");
    String popped = stack.pop();
    stack.push("nodo-3");
    stack.push("nodo-4");
    stack.pop();
    return ExerciseSupport.format(
        ExerciseSupport.named("firstPop", popped),
        ExerciseSupport.named("peek", stack.peek()),
        ExerciseSupport.named("size", stack.size()));
  }

}