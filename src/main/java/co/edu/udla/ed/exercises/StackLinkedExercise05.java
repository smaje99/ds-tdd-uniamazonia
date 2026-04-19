package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Stack;

/**
 * Guided exercise 05 for the linked stack series.
 *
 * <p>This scenario uses learner domain objects so the pop order can be inspected with custom values. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class StackLinkedExercise05 extends AbstractStackLinkedDomainExercise {

  @Override
  protected String solve(Stack<ExerciseSupport.Learner> stack) {
    stack.push(ExerciseSupport.learner("Eva", 99));
    stack.push(ExerciseSupport.learner("Ana", 101));
    stack.push(ExerciseSupport.learner("Luis", 203));
    stack.pop();
    stack.push(ExerciseSupport.learner("Mia", 305));
    return ExerciseSupport.format(
        ExerciseSupport.named("peekIsMia", stack.peek().equals(ExerciseSupport.learner("Mia", 305))),
        ExerciseSupport.named("drain", popAll(stack)));
  }

}
