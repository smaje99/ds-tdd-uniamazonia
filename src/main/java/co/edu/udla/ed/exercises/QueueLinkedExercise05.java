package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.LinkedQueue;

/**
 * Exercise 05 for the Linked Queue series.
 *
 * <p><strong>Student task:</strong> Use domain objects to validate the front element, one served value, and the remaining FIFO order.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class QueueLinkedExercise05 {

  /**
   * Solves Exercise 05 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(LinkedQueue<ExerciseSupport.Learner> queue) {
    queue.enqueue(ExerciseSupport.learner("Eva", 99));
    queue.enqueue(ExerciseSupport.learner("Ana", 101));
    queue.enqueue(ExerciseSupport.learner("Luis", 203));
    ExerciseSupport.Learner served = queue.dequeue();
    queue.enqueue(ExerciseSupport.learner("Mia", 305));
    return ExerciseSupport.format(
        ExerciseSupport.named("served", served),
        ExerciseSupport.named("peekIsAna", queue.peek().equals(ExerciseSupport.learner("Ana", 101))),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithIterator(queue)));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayDeque<ExerciseSupport.Learner> queue) {
    queue.addLast(ExerciseSupport.learner("Eva", 99));
    queue.addLast(ExerciseSupport.learner("Ana", 101));
    queue.addLast(ExerciseSupport.learner("Luis", 203));
    ExerciseSupport.Learner served = queue.removeFirst();
    queue.addLast(ExerciseSupport.learner("Mia", 305));
    return ExerciseSupport.format(
        ExerciseSupport.named("served", served),
        ExerciseSupport.named("peekIsAna", queue.peekFirst().equals(ExerciseSupport.learner("Ana", 101))),
        ExerciseSupport.named("remaining", ExerciseSupport.drainDequeWithLoop(queue)));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayDeque<ExerciseSupport.Learner> queue) {
    queue.addLast(ExerciseSupport.learner("Eva", 99));
    queue.addLast(ExerciseSupport.learner("Ana", 101));
    queue.addLast(ExerciseSupport.learner("Luis", 203));
    ExerciseSupport.Learner served = queue.removeFirst();
    queue.addLast(ExerciseSupport.learner("Mia", 305));
    return ExerciseSupport.format(
        ExerciseSupport.named("served", served),
        ExerciseSupport.named("peekIsAna", queue.peekFirst().equals(ExerciseSupport.learner("Ana", 101))),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithStreams(queue)));
  }

}
