package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Queue;

/**
 * Guided exercise 05 for the linked queue series.
 *
 * <p>This scenario uses learner domain objects so the dequeue order can be inspected with custom values. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class QueueLinkedExercise05 extends AbstractQueueLinkedDomainExercise {

  @Override
  protected String solve(Queue<ExerciseSupport.Learner> queue) {
    queue.enqueue(ExerciseSupport.learner("Eva", 99));
    queue.enqueue(ExerciseSupport.learner("Ana", 101));
    queue.enqueue(ExerciseSupport.learner("Luis", 203));
    ExerciseSupport.Learner served = queue.dequeue();
    queue.enqueue(ExerciseSupport.learner("Mia", 305));
    return ExerciseSupport.format(
        ExerciseSupport.named("served", served),
        ExerciseSupport.named("peekIsAna", queue.peek().equals(ExerciseSupport.learner("Ana", 101))),
        ExerciseSupport.named("remaining", dequeueAll(queue)));
  }

}
