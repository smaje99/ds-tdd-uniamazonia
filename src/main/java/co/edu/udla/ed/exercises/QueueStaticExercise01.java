package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.StaticQueue;

public final class QueueStaticExercise01 {

  public String solveWithCustomIterator(StaticQueue<String> queue) {
    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");
    return ExerciseSupport.format(
        ExerciseSupport.named("peek", queue.peek()),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(queue)));
  }

  public String solveWithJavaLoops(ArrayDeque<String> queue) {
    queue.addLast("A");
    queue.addLast("B");
    queue.addLast("C");
    return ExerciseSupport.format(
        ExerciseSupport.named("peek", queue.peekFirst()),
        ExerciseSupport.named("size", queue.size()));
  }

  public String solveWithStreams(ArrayDeque<String> queue) {
    queue.addLast("A");
    queue.addLast("B");
    queue.addLast("C");
    return ExerciseSupport.format(
        ExerciseSupport.named("peek", queue.peekFirst()),
        ExerciseSupport.named("size", queue.stream().count()));
  }

}
