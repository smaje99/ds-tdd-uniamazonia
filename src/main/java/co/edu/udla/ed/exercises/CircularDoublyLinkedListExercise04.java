package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.CircularDoublyLinkedList;

/**
 * Exercise 04 for the Circular Doubly Linked List series.
 *
 * <p><strong>Student task:</strong> Run a longer insertion scenario to verify that circular bookkeeping does not alter the logical order.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class CircularDoublyLinkedListExercise04 {

  /**
   * Solves Exercise 04 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(CircularDoublyLinkedList<String> list) {
    list.addLast("base");
    list.addLast("temporal");
    list.clear();
    list.addFirst("nuevo-inicio");
    list.addLast("nuevo-final");
    list.addLast("cierre");
    return ExerciseSupport.snapshotWithIterator(list);
  }

  /**
   * Solves Exercise 04 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addLast("base");
    list.addLast("temporal");
    list.clear();
    list.addFirst("nuevo-inicio");
    list.addLast("nuevo-final");
    list.addLast("cierre");
    return ExerciseSupport.snapshotWithLoop(list);
  }

  /**
   * Solves Exercise 04 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(LinkedList<String> list) {
    list.addLast("base");
    list.addLast("temporal");
    list.clear();
    list.addFirst("nuevo-inicio");
    list.addLast("nuevo-final");
    list.addLast("cierre");
    return ExerciseSupport.snapshotWithStreams(list);
  }

}
