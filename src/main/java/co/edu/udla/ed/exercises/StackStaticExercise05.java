package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Stack;

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
