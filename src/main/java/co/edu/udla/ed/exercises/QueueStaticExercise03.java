package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Queue;

/**
 * Guided exercise 03 for the array-backed queue series.
 *
 * <p>This scenario interleaves enqueues and dequeues so students can reason about the current size. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
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