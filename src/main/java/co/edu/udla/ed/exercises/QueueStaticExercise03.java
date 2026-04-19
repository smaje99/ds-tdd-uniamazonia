package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Queue;

public final class QueueStaticExercise03 extends AbstractQueueStaticExercise {

  @Override
  protected String solve(Queue<String> queue) {
    queue.enqueue("A");
    queue.enqueue("B");
    String firstOut = queue.dequeue();
    queue.enqueue("C");
    queue.enqueue("D");
    return ExerciseSupport.format(
        ExerciseSupport.named("firstOut", firstOut),
        ExerciseSupport.named("peek", queue.peek()),
        ExerciseSupport.named("size", queue.size()));
  }

}