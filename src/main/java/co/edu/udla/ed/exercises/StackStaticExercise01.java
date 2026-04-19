package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Stack;

/**
 * Guided exercise 01 for the array-backed stack series.
 *
 * <p>This scenario introduces push and peek on the array-backed stack. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class StackStaticExercise01 extends AbstractStackStaticExercise {

  @Override
  protected String solve(Stack<String> stack) {
    stack.push("A");
    stack.push("B");
    stack.push("C");
    return ExerciseSupport.format(
        ExerciseSupport.named("peek", stack.peek()),
        ExerciseSupport.named("size", stack.size()));
  }

}