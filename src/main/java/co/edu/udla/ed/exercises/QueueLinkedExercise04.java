package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.LinkedQueue;

public final class QueueLinkedExercise04 {

  public String solveWithCustomIterator(LinkedQueue<String> queue) {
    queue.enqueue("uno");
    queue.enqueue("dos");
    queue.enqueue("tres");
    queue.dequeue();
    queue.dequeue();
    queue.enqueue("cuatro");
    queue.enqueue("cinco");
    return ExerciseSupport.named("dequeues", ExerciseSupport.snapshotWithIterator(queue));
  }

  public String solveWithJavaLoops(ArrayDeque<String> queue) {
    queue.addLast("uno");
    queue.addLast("dos");
    queue.addLast("tres");
    queue.removeFirst();
    queue.removeFirst();
    queue.addLast("cuatro");
    queue.addLast("cinco");
    return ExerciseSupport.named("dequeues", ExerciseSupport.drainDequeWithLoop(queue));
  }

  public String solveWithStreams(ArrayDeque<String> queue) {
    queue.addLast("uno");
    queue.addLast("dos");
    queue.addLast("tres");
    queue.removeFirst();
    queue.removeFirst();
    queue.addLast("cuatro");
    queue.addLast("cinco");
    return ExerciseSupport.named("dequeues", ExerciseSupport.snapshotWithStreams(queue));
  }

}
