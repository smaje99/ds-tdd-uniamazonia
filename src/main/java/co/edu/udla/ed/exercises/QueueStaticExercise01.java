package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Queue;

public final class QueueStaticExercise01 extends AbstractQueueStaticExercise {

  @Override
  protected String solve(Queue<String> queue) {
    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");
    return ExerciseSupport.format(
        ExerciseSupport.named("peek", queue.peek()),
        ExerciseSupport.named("size", queue.size()));
  }

}