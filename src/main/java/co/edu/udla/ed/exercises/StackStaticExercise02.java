package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Stack;

/**
 * Guided exercise 02 for the array-backed stack series.
 *
 * <p>This scenario pops elements to expose the LIFO removal order. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class StackStaticExercise02 extends AbstractStackStaticExercise {

  @Override
  protected String solve(Stack<String> stack) {
    stack.push("uno");
    stack.push("dos");
    stack.push("tres");
    return ExerciseSupport.named("pops", popAll(stack));
  }

}