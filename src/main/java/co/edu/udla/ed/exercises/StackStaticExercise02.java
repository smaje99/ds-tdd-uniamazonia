package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Stack;

public final class StackStaticExercise02 extends AbstractStackStaticExercise {

  @Override
  protected String solve(Stack<String> stack) {
    stack.push("uno");
    stack.push("dos");
    stack.push("tres");
    return ExerciseSupport.named("pops", popAll(stack));
  }

}