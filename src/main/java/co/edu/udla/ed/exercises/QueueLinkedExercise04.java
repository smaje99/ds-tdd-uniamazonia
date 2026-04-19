package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Queue;

/**
 * Guided exercise 04 for the linked queue series.
 *
 * <p>This scenario partially drains the queue, rebuilds it, and reports the final order. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
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