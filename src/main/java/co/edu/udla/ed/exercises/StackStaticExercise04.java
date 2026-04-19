package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Stack;

public final class StackStaticExercise04 extends AbstractStackStaticExercise {

  @Override
  protected String solve(Stack<String> stack) {
    stack.push("0");
    stack.push("1");
    stack.push("2");
    stack.push("3");
    stack.push("4");
    stack.push("5");
    stack.push("6");
    stack.push("7");
    stack.push("8");
    stack.push("9");
    stack.push("10");
    stack.push("11");
    return ExerciseSupport.named("pops", popAll(stack));
  }

}