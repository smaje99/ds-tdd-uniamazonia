package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Queue;

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
