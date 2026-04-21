package co.edu.udla.ed.exercises;

import co.edu.udla.ed.impl.scratch.BinaryHeapPriorityQueue;

/**
 * Exercise 05 for the Priority Queue series.
 *
 * <p><strong>Student task:</strong> Clear a priority queue, reinsert new values, and inspect the rebuilt state.</p>
 */
public final class PriorityQueueExercise05 {

  public String solveWithCustomIterator(BinaryHeapPriorityQueue<Integer> queue) {
    queue.insert(9);
    queue.insert(4);
    queue.clear();
    queue.insert(6);
    queue.insert(1);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(queue)),
        ExerciseSupport.named("drain", java.util.List.of(queue.removeMin(), queue.removeMin())));
  }

  public String solveWithJavaLoops(java.util.PriorityQueue<Integer> queue) {
    queue.add(9);
    queue.add(4);
    queue.clear();
    queue.add(6);
    queue.add(1);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", queue.size()),
        ExerciseSupport.named("drain", ExerciseSupport.priorityQueueDrainWithLoop(queue)));
  }

  public String solveWithStreams(java.util.PriorityQueue<Integer> queue) {
    queue.add(9);
    queue.add(4);
    queue.clear();
    queue.add(6);
    queue.add(1);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", queue.stream().count()),
        ExerciseSupport.named("drain", ExerciseSupport.priorityQueueDrainWithStreams(queue)));
  }

}
