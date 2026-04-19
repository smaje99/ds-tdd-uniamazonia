package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Stack;

public final class StackLinkedExercise01 extends AbstractStackLinkedExercise {

  @Override
  protected String solve(Stack<String> stack) {
    stack.push("rojo");
    stack.push("verde");
    stack.push("azul");
    return ExerciseSupport.format(
        ExerciseSupport.named("peek", stack.peek()),
        ExerciseSupport.named("size", stack.size()));
  }

}