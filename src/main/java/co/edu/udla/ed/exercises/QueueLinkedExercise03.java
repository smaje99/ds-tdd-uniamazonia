package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Queue;

public final class QueueLinkedExercise03 extends AbstractQueueLinkedExercise {

  @Override
  protected String solve(Queue<String> queue) {
    queue.enqueue("n1");
    queue.enqueue("n2");
    String firstOut = queue.dequeue();
    queue.enqueue("n3");
    return ExerciseSupport.format(
        ExerciseSupport.named("firstOut", firstOut),
        ExerciseSupport.named("peek", queue.peek()),
        ExerciseSupport.named("size", queue.size()));
  }

}