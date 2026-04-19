package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Stack;

/**
 * Guided exercise 04 for the linked stack series.
 *
 * <p>This scenario drains the whole structure to make the final pop order explicit. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
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