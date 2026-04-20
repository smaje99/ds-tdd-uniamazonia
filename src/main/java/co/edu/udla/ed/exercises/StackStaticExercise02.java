package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.StaticStack;

public final class StackStaticExercise02 {

  public String solveWithCustomIterator(StaticStack<String> stack) {
    stack.push("uno");
    stack.push("dos");
    stack.push("tres");
    return ExerciseSupport.named("pops", ExerciseSupport.snapshotWithIterator(stack));
  }

  public String solveWithJavaLoops(ArrayDeque<String> stack) {
    stack.addLast("uno");
    stack.addLast("dos");
    stack.addLast("tres");
    return ExerciseSupport.named("pops", ExerciseSupport.stackDrainWithLoop(stack));
  }

  public String solveWithStreams(ArrayDeque<String> stack) {
    stack.addLast("uno");
    stack.addLast("dos");
    stack.addLast("tres");
    return ExerciseSupport.named("pops", ExerciseSupport.stackDrainWithStreams(stack));
  }

}
