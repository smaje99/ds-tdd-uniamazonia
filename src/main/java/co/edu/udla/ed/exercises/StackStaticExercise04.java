package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.StaticStack;

public final class StackStaticExercise04 {

  public String solveWithCustomIterator(StaticStack<String> stack) {
    for (int i = 0; i <= 11; i++) {
      stack.push(String.valueOf(i));
    }
    return ExerciseSupport.named("pops", ExerciseSupport.snapshotWithIterator(stack));
  }

  public String solveWithJavaLoops(ArrayDeque<String> stack) {
    for (int i = 0; i <= 11; i++) {
      stack.addLast(String.valueOf(i));
    }
    return ExerciseSupport.named("pops", ExerciseSupport.stackDrainWithLoop(stack));
  }

  public String solveWithStreams(ArrayDeque<String> stack) {
    for (int i = 0; i <= 11; i++) {
      stack.addLast(String.valueOf(i));
    }
    return ExerciseSupport.named("pops", ExerciseSupport.stackDrainWithStreams(stack));
  }

}
