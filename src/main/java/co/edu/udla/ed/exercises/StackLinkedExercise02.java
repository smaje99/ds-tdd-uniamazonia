package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Stack;

public final class StackLinkedExercise02 extends AbstractStackLinkedExercise {

  @Override
  protected String solve(Stack<String> stack) {
    stack.push("A");
    stack.push("B");
    stack.push("C");
    return ExerciseSupport.named("pops", popAll(stack));
  }

}