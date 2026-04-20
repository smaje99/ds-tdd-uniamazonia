package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.LinkedQueue;

public final class QueueLinkedExercise03 {

  public String solveWithCustomIterator(LinkedQueue<String> queue) {
    queue.enqueue("n1");
    queue.enqueue("n2");
    String firstOut = queue.dequeue();
    queue.enqueue("n3");
    return ExerciseSupport.format(
        ExerciseSupport.named("firstOut", firstOut),
        ExerciseSupport.named("peek", queue.peek()),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(queue)));
  }

  public String solveWithJavaLoops(ArrayDeque<String> queue) {
    queue.addLast("n1");
    queue.addLast("n2");
    String firstOut = queue.removeFirst();
    queue.addLast("n3");
    return ExerciseSupport.format(
        ExerciseSupport.named("firstOut", firstOut),
        ExerciseSupport.named("peek", queue.peekFirst()),
        ExerciseSupport.named("size", queue.size()));
  }

  public String solveWithStreams(ArrayDeque<String> queue) {
    queue.addLast("n1");
    queue.addLast("n2");
    String firstOut = queue.removeFirst();
    queue.addLast("n3");
    return ExerciseSupport.format(
        ExerciseSupport.named("firstOut", firstOut),
        ExerciseSupport.named("peek", queue.peekFirst()),
        ExerciseSupport.named("size", queue.stream().count()));
  }

}
