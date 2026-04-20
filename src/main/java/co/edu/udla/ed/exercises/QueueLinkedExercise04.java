package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.LinkedQueue;

/**
 * Exercise 04 for the Linked Queue series.
 *
 * <p><strong>Student task:</strong> Execute a longer enqueue/dequeue scenario to verify that logical FIFO order is preserved.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class QueueLinkedExercise04 {

  /**
   * Solves Exercise 04 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
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

  /**
   * Solves Exercise 04 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
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

  /**
   * Solves Exercise 04 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
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
