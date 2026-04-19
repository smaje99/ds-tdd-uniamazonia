package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Stack;

/**
 * Guided exercise 02 for the linked stack series.
 *
 * <p>This scenario pops elements to expose the LIFO removal order. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class StackLinkedExercise02 extends AbstractStackLinkedExercise {

  @Override
  protected String solve(Stack<String> stack) {
    stack.push("A");
    stack.push("B");
    stack.push("C");
    return ExerciseSupport.named("pops", popAll(stack));
  }

}