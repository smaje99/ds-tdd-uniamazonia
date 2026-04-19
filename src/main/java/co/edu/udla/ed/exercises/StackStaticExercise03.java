package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Stack;

public final class StackStaticExercise03 extends AbstractStackStaticExercise {

  @Override
  protected String solve(Stack<String> stack) {
    stack.push("A");
    stack.push("B");
    String popped = stack.pop();
    stack.push("C");
    return ExerciseSupport.format(
        ExerciseSupport.named("popped", popped),
        ExerciseSupport.named("peek", stack.peek()),
        ExerciseSupport.named("size", stack.size()));
  }

}