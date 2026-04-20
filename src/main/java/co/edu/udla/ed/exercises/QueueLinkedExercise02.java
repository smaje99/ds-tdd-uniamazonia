package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.LinkedQueue;

public final class QueueLinkedExercise02 {

  public String solveWithCustomIterator(LinkedQueue<String> queue) {
    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");
    return ExerciseSupport.named("dequeues", ExerciseSupport.snapshotWithIterator(queue));
  }

  public String solveWithJavaLoops(ArrayDeque<String> queue) {
    queue.addLast("A");
    queue.addLast("B");
    queue.addLast("C");
    return ExerciseSupport.named("dequeues", ExerciseSupport.drainDequeWithLoop(queue));
  }

  public String solveWithStreams(ArrayDeque<String> queue) {
    queue.addLast("A");
    queue.addLast("B");
    queue.addLast("C");
    return ExerciseSupport.named("dequeues", ExerciseSupport.snapshotWithStreams(queue));
  }

}
