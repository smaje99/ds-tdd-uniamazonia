package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.SinglyLinkedList;

/**
 * Exercise 04 for the Linked Simple List series.
 *
 * <p><strong>Student task:</strong> Force a longer insertion sequence so the student can observe growth while preserving logical order.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class SimpleListLinkedExercise04 {

  /**
   * Solves Exercise 04 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(SinglyLinkedList<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addFirst("cero");
    list.removeFirst();
    list.addLast("tres");
    list.addLast("cuatro");
    list.addFirst("cabecera");
    list.addLast("cinco");
    return ExerciseSupport.snapshotWithIterator(list);
  }

  /**
   * Solves Exercise 04 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addFirst("cero");
    list.removeFirst();
    list.addLast("tres");
    list.addLast("cuatro");
    list.addFirst("cabecera");
    list.addLast("cinco");
    return ExerciseSupport.snapshotWithLoop(list);
  }

  /**
   * Solves Exercise 04 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(LinkedList<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addFirst("cero");
    list.removeFirst();
    list.addLast("tres");
    list.addLast("cuatro");
    list.addFirst("cabecera");
    list.addLast("cinco");
    return ExerciseSupport.snapshotWithStreams(list);
  }

}
