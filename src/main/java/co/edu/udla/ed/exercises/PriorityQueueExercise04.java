package co.edu.udla.ed.exercises;

import co.edu.udla.ed.impl.scratch.BinaryHeapPriorityQueue;

/**
 * Exercise 04 for the Priority Queue series.
 *
 * <p><strong>Student task:</strong> Attempt to remove the minimum value from an empty priority queue and observe the
 * expected exception.</p>
 */
public final class PriorityQueueExercise04 {

  public String solveWithCustomIterator(BinaryHeapPriorityQueue<Integer> queue) {
    queue.removeMin();
    return "unreachable";
  }

  public String solveWithJavaLoops(java.util.PriorityQueue<Integer> queue) {
    queue.remove();
    return "unreachable";
  }

  public String solveWithStreams(java.util.PriorityQueue<Integer> queue) {
    queue.remove();
    return "unreachable";
  }

}
