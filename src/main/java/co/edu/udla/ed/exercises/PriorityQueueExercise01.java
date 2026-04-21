package co.edu.udla.ed.exercises;

import co.edu.udla.ed.impl.scratch.BinaryHeapPriorityQueue;

/**
 * Exercise 01 for the Priority Queue series.
 *
 * <p><strong>Student task:</strong> Insert several values into a minimum priority queue and report its size together
 * with the current minimum.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class PriorityQueueExercise01 {

  public String solveWithCustomIterator(BinaryHeapPriorityQueue<Integer> queue) {
    queue.insert(7);
    queue.insert(1);
    queue.insert(5);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(queue)),
        ExerciseSupport.named("min", queue.peekMin()));
  }

  public String solveWithJavaLoops(java.util.PriorityQueue<Integer> queue) {
    queue.add(7);
    queue.add(1);
    queue.add(5);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", queue.size()),
        ExerciseSupport.named("min", queue.peek()));
  }

  public String solveWithStreams(java.util.PriorityQueue<Integer> queue) {
    queue.add(7);
    queue.add(1);
    queue.add(5);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", queue.stream().count()),
        ExerciseSupport.named("min", queue.peek()));
  }

}
