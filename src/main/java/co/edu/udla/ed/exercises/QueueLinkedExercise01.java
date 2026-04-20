package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.LinkedQueue;

public final class QueueLinkedExercise01 {

  public String solveWithCustomIterator(LinkedQueue<String> queue) {
    queue.enqueue("primero");
    queue.enqueue("segundo");
    queue.enqueue("tercero");
    return ExerciseSupport.format(
        ExerciseSupport.named("peek", queue.peek()),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(queue)));
  }

  public String solveWithJavaLoops(ArrayDeque<String> queue) {
    queue.addLast("primero");
    queue.addLast("segundo");
    queue.addLast("tercero");
    return ExerciseSupport.format(
        ExerciseSupport.named("peek", queue.peekFirst()),
        ExerciseSupport.named("size", queue.size()));
  }

  public String solveWithStreams(ArrayDeque<String> queue) {
    queue.addLast("primero");
    queue.addLast("segundo");
    queue.addLast("tercero");
    return ExerciseSupport.format(
        ExerciseSupport.named("peek", queue.peekFirst()),
        ExerciseSupport.named("size", queue.stream().count()));
  }

}
