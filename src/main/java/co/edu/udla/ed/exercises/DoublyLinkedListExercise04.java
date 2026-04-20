package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.DoublyLinkedList;

/**
 * Exercise 04 for the Doubly Linked List series.
 *
 * <p><strong>Student task:</strong> Execute a longer insertion sequence so the student can inspect stable ordering after repeated updates.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class DoublyLinkedListExercise04 {

  /**
   * Solves Exercise 04 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(DoublyLinkedList<String> list) {
    list.addLast("base-1");
    list.addLast("base-2");
    list.clear();
    list.addLast("nuevo-1");
    list.addLast("nuevo-2");
    list.addFirst("nuevo-0");
    return ExerciseSupport.snapshotWithIterator(list);
  }

  /**
   * Solves Exercise 04 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addLast("base-1");
    list.addLast("base-2");
    list.clear();
    list.addLast("nuevo-1");
    list.addLast("nuevo-2");
    list.addFirst("nuevo-0");
    return ExerciseSupport.snapshotWithLoop(list);
  }

  /**
   * Solves Exercise 04 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(LinkedList<String> list) {
    list.addLast("base-1");
    list.addLast("base-2");
    list.clear();
    list.addLast("nuevo-1");
    list.addLast("nuevo-2");
    list.addFirst("nuevo-0");
    return ExerciseSupport.snapshotWithStreams(list);
  }

}
