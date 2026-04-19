package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Queue;

public final class QueueStaticExercise02 extends AbstractQueueStaticExercise {

  @Override
  protected String solve(Queue<String> queue) {
    queue.enqueue("uno");
    queue.enqueue("dos");
    queue.enqueue("tres");
    return ExerciseSupport.named("dequeues", dequeueAll(queue));
  }

}