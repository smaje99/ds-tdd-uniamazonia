package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Stack;

public final class StackLinkedExercise04 extends AbstractStackLinkedExercise {

  @Override
  protected String solve(Stack<String> stack) {
    stack.push("primero");
    stack.push("segundo");
    stack.push("tercero");
    stack.push("cuarto");
    stack.push("quinto");
    return ExerciseSupport.named("pops", popAll(stack));
  }

}