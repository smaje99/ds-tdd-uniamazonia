package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Stack;

/**
 * Guided exercise 03 for the array-backed stack series.
 *
 * <p>This scenario interleaves pushes and pops so students can reason about the current size. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
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