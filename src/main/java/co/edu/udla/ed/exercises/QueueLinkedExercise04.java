package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Queue;

public final class QueueLinkedExercise04 extends AbstractQueueLinkedExercise {

  @Override
  protected String solve(Queue<String> queue) {
    queue.enqueue("uno");
    queue.enqueue("dos");
    queue.enqueue("tres");
    queue.dequeue();
    queue.dequeue();
    queue.enqueue("cuatro");
    queue.enqueue("cinco");
    return ExerciseSupport.named("dequeues", dequeueAll(queue));
  }

}