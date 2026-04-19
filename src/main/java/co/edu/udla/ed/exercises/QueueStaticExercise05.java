package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Queue;

/**
 * Guided exercise 05 for the array-backed queue series.
 *
 * <p>This scenario uses learner domain objects to validate FIFO behavior through custom values. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class QueueStaticExercise05 extends AbstractQueueStaticDomainExercise {

  @Override
  protected String solve(Queue<ExerciseSupport.Learner> queue) {
    queue.enqueue(ExerciseSupport.learner("Ana", 101));
    queue.enqueue(ExerciseSupport.learner("Luis", 203));
    queue.enqueue(ExerciseSupport.learner("Mia", 305));
    boolean frontMatches = queue.peek().equals(ExerciseSupport.learner("Ana", 101));
    ExerciseSupport.Learner served = queue.dequeue();
    return ExerciseSupport.format(
        ExerciseSupport.named("frontMatches", frontMatches),
        ExerciseSupport.named("served", served),
        ExerciseSupport.named("remaining", dequeueAll(queue)));
  }

}
