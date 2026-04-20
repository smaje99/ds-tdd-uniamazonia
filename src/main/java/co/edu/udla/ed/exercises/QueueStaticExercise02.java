package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.StaticQueue;

public final class QueueStaticExercise02 {

  public String solveWithCustomIterator(StaticQueue<String> queue) {
    queue.enqueue("uno");
    queue.enqueue("dos");
    queue.enqueue("tres");
    return ExerciseSupport.named("dequeues", ExerciseSupport.snapshotWithIterator(queue));
  }

  public String solveWithJavaLoops(ArrayDeque<String> queue) {
    queue.addLast("uno");
    queue.addLast("dos");
    queue.addLast("tres");
    return ExerciseSupport.named("dequeues", ExerciseSupport.drainDequeWithLoop(queue));
  }

  public String solveWithStreams(ArrayDeque<String> queue) {
    queue.addLast("uno");
    queue.addLast("dos");
    queue.addLast("tres");
    return ExerciseSupport.named("dequeues", ExerciseSupport.snapshotWithStreams(queue));
  }

}
