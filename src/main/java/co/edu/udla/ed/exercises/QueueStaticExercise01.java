package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.StaticQueue;

/**
 * Exercise 01 for the Static Queue series.
 *
 * <p><strong>Student task:</strong> Enqueue several values, inspect the front element, and report the current size.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class QueueStaticExercise01 {

  /**
   * Solves Exercise 01 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(StaticQueue<String> queue) {
    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");
    return ExerciseSupport.format(
        ExerciseSupport.named("peek", queue.peek()),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(queue)));
  }

  /**
   * Solves Exercise 01 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayDeque<String> queue) {
    queue.addLast("A");
    queue.addLast("B");
    queue.addLast("C");
    return ExerciseSupport.format(
        ExerciseSupport.named("peek", queue.peekFirst()),
        ExerciseSupport.named("size", queue.size()));
  }

  /**
   * Solves Exercise 01 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayDeque<String> queue) {
    queue.addLast("A");
    queue.addLast("B");
    queue.addLast("C");
    return ExerciseSupport.format(
        ExerciseSupport.named("peek", queue.peekFirst()),
        ExerciseSupport.named("size", queue.stream().count()));
  }

}
