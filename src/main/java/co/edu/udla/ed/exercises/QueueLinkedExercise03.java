package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.LinkedQueue;

/**
 * Exercise 03 for the Linked Queue series.
 *
 * <p><strong>Student task:</strong> Interleave enqueues and dequeues, then report the first removed value, the current front, and the size.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class QueueLinkedExercise03 {

  /**
   * Solves Exercise 03 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(LinkedQueue<String> queue) {
    queue.enqueue("n1");
    queue.enqueue("n2");
    String firstOut = queue.dequeue();
    queue.enqueue("n3");
    return ExerciseSupport.format(
        ExerciseSupport.named("firstOut", firstOut),
        ExerciseSupport.named("peek", queue.peek()),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(queue)));
  }

  /**
   * Solves Exercise 03 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayDeque<String> queue) {
    queue.addLast("n1");
    queue.addLast("n2");
    String firstOut = queue.removeFirst();
    queue.addLast("n3");
    return ExerciseSupport.format(
        ExerciseSupport.named("firstOut", firstOut),
        ExerciseSupport.named("peek", queue.peekFirst()),
        ExerciseSupport.named("size", queue.size()));
  }

  /**
   * Solves Exercise 03 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayDeque<String> queue) {
    queue.addLast("n1");
    queue.addLast("n2");
    String firstOut = queue.removeFirst();
    queue.addLast("n3");
    return ExerciseSupport.format(
        ExerciseSupport.named("firstOut", firstOut),
        ExerciseSupport.named("peek", queue.peekFirst()),
        ExerciseSupport.named("size", queue.stream().count()));
  }

}
