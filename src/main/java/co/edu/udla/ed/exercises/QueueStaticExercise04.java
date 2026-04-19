package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Queue;

public final class QueueStaticExercise04 extends AbstractQueueStaticExercise {

  @Override
  protected String solve(Queue<String> queue) {
    queue.enqueue("0");
    queue.enqueue("1");
    queue.enqueue("2");
    queue.enqueue("3");
    queue.enqueue("4");
    queue.enqueue("5");
    queue.enqueue("6");
    queue.enqueue("7");

    queue.dequeue();
    queue.dequeue();
    queue.dequeue();

    queue.enqueue("8");
    queue.enqueue("9");
    queue.enqueue("10");
    queue.enqueue("11");
    queue.enqueue("12");

    return ExerciseSupport.named("dequeues", dequeueAll(queue));
  }

}