package co.edu.udla.ed.exercises;

import co.edu.udla.ed.impl.scratch.BinaryHeapPriorityQueue;

/**
 * Exercise 03 for the Priority Queue series.
 *
 * <p><strong>Student task:</strong> Work with duplicate priorities, remove the smallest value once, and inspect the
 * remaining queue state.</p>
 */
public final class PriorityQueueExercise03 {

  public String solveWithCustomIterator(BinaryHeapPriorityQueue<Integer> queue) {
    queue.insert(4);
    queue.insert(2);
    queue.insert(4);
    queue.insert(2);
    int removed = queue.removeMin();
    java.util.List<Integer> remaining = java.util.List.of(queue.removeMin(), queue.removeMin(), queue.removeMin());
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("remaining", remaining));
  }

  public String solveWithJavaLoops(java.util.PriorityQueue<Integer> queue) {
    queue.add(4);
    queue.add(2);
    queue.add(4);
    queue.add(2);
    int removed = queue.remove();
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("remaining", ExerciseSupport.priorityQueueDrainWithLoop(queue)));
  }

  public String solveWithStreams(java.util.PriorityQueue<Integer> queue) {
    queue.add(4);
    queue.add(2);
    queue.add(4);
    queue.add(2);
    int removed = queue.remove();
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("remaining", ExerciseSupport.priorityQueueDrainWithStreams(queue)));
  }

}
