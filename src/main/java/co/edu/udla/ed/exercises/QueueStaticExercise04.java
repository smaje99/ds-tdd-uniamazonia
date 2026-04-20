package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.StaticQueue;

public final class QueueStaticExercise04 {

  public String solveWithCustomIterator(StaticQueue<String> queue) {
    for (int i = 0; i <= 7; i++) {
      queue.enqueue(String.valueOf(i));
    }
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    for (int i = 8; i <= 12; i++) {
      queue.enqueue(String.valueOf(i));
    }
    return ExerciseSupport.named("dequeues", ExerciseSupport.snapshotWithIterator(queue));
  }

  public String solveWithJavaLoops(ArrayDeque<String> queue) {
    for (int i = 0; i <= 7; i++) {
      queue.addLast(String.valueOf(i));
    }
    queue.removeFirst();
    queue.removeFirst();
    queue.removeFirst();
    for (int i = 8; i <= 12; i++) {
      queue.addLast(String.valueOf(i));
    }
    return ExerciseSupport.named("dequeues", ExerciseSupport.drainDequeWithLoop(queue));
  }

  public String solveWithStreams(ArrayDeque<String> queue) {
    for (int i = 0; i <= 7; i++) {
      queue.addLast(String.valueOf(i));
    }
    queue.removeFirst();
    queue.removeFirst();
    queue.removeFirst();
    for (int i = 8; i <= 12; i++) {
      queue.addLast(String.valueOf(i));
    }
    return ExerciseSupport.named("dequeues", ExerciseSupport.snapshotWithStreams(queue));
  }

}
