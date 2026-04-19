package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Stack;

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
