package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Queue;

public final class QueueLinkedExercise02 extends AbstractQueueLinkedExercise {

  @Override
  protected String solve(Queue<String> queue) {
    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");
    return ExerciseSupport.named("dequeues", dequeueAll(queue));
  }

}