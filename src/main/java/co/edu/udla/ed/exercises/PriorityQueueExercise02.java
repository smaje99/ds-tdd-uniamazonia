package co.edu.udla.ed.exercises;

import co.edu.udla.ed.impl.scratch.BinaryHeapPriorityQueue;

/**
 * Exercise 02 for the Priority Queue series.
 *
 * <p><strong>Student task:</strong> Insert several values and then remove them in priority order.</p>
 */
public final class PriorityQueueExercise02 {

  public String solveWithCustomIterator(BinaryHeapPriorityQueue<Integer> queue) {
    queue.insert(7);
    queue.insert(3);
    queue.insert(5);
    queue.insert(1);
    return ExerciseSupport.snapshot(queue.removeMin() == 1 ? java.util.List.of(1, queue.removeMin(), queue.removeMin(), queue.removeMin()) : java.util.List.of());
  }

  public String solveWithJavaLoops(java.util.PriorityQueue<Integer> queue) {
    queue.add(7);
    queue.add(3);
    queue.add(5);
    queue.add(1);
    return ExerciseSupport.priorityQueueDrainWithLoop(queue);
  }

  public String solveWithStreams(java.util.PriorityQueue<Integer> queue) {
    queue.add(7);
    queue.add(3);
    queue.add(5);
    queue.add(1);
    return ExerciseSupport.priorityQueueDrainWithStreams(queue);
  }

}
