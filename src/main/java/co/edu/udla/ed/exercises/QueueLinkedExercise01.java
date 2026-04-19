package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Queue;

public final class QueueLinkedExercise01 extends AbstractQueueLinkedExercise {

  @Override
  protected String solve(Queue<String> queue) {
    queue.enqueue("primero");
    queue.enqueue("segundo");
    queue.enqueue("tercero");
    return ExerciseSupport.format(
        ExerciseSupport.named("peek", queue.peek()),
        ExerciseSupport.named("size", queue.size()));
  }

}