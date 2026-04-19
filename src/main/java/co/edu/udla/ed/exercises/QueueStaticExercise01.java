package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Queue;

/**
 * Guided exercise 01 for the array-backed queue series.
 *
 * <p>This scenario introduces enqueue and peek on the array-backed queue. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
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