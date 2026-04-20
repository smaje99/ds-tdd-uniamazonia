package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.StaticQueue;

public final class QueueStaticExercise03 {

  public String solveWithCustomIterator(StaticQueue<String> queue) {
    queue.enqueue("A");
    queue.enqueue("B");
    String firstOut = queue.dequeue();
    queue.enqueue("C");
    queue.enqueue("D");
    return ExerciseSupport.format(
        ExerciseSupport.named("firstOut", firstOut),
        ExerciseSupport.named("peek", queue.peek()),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(queue)));
  }

  public String solveWithJavaLoops(ArrayDeque<String> queue) {
    queue.addLast("A");
    queue.addLast("B");
    String firstOut = queue.removeFirst();
    queue.addLast("C");
    queue.addLast("D");
    return ExerciseSupport.format(
        ExerciseSupport.named("firstOut", firstOut),
        ExerciseSupport.named("peek", queue.peekFirst()),
        ExerciseSupport.named("size", queue.size()));
  }

  public String solveWithStreams(ArrayDeque<String> queue) {
    queue.addLast("A");
    queue.addLast("B");
    String firstOut = queue.removeFirst();
    queue.addLast("C");
    queue.addLast("D");
    return ExerciseSupport.format(
        ExerciseSupport.named("firstOut", firstOut),
        ExerciseSupport.named("peek", queue.peekFirst()),
        ExerciseSupport.named("size", queue.stream().count()));
  }

}
