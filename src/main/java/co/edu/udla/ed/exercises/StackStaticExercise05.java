package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Stack;

/**
 * Guided exercise 05 for the array-backed stack series.
 *
 * <p>This scenario uses learner domain objects to validate LIFO behavior through custom values. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class StackStaticExercise05 extends AbstractStackStaticDomainExercise {

  @Override
  protected String solve(Stack<ExerciseSupport.Learner> stack) {
    stack.push(ExerciseSupport.learner("Ana", 101));
    stack.push(ExerciseSupport.learner("Luis", 203));
    stack.push(ExerciseSupport.learner("Mia", 305));
    boolean topMatches = stack.peek().equals(ExerciseSupport.learner("Mia", 305));
    ExerciseSupport.Learner popped = stack.pop();
    return ExerciseSupport.format(
        ExerciseSupport.named("topMatches", topMatches),
        ExerciseSupport.named("popped", popped),
        ExerciseSupport.named("remaining", popAll(stack)));
  }

}
