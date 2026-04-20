package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.StaticQueue;

/**
 * Exercise 04 for the Static Queue series.
 *
 * <p><strong>Student task:</strong> Execute a wrap-around style sequence so the student can verify that logical FIFO order is preserved.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class QueueStaticExercise04 {

  /**
   * Solves Exercise 04 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
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

  /**
   * Solves Exercise 04 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
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

  /**
   * Solves Exercise 04 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
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
