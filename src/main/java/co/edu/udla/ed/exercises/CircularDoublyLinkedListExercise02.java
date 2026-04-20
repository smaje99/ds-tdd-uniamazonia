package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.CircularDoublyLinkedList;

/**
 * Exercise 02 for the Circular Doubly Linked List series.
 *
 * <p><strong>Student task:</strong> Populate the list, remove the first and last logical elements, and report the removed values plus the remainder.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class CircularDoublyLinkedListExercise02 {

  /**
   * Solves Exercise 02 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(CircularDoublyLinkedList<String> list) {
    list.addFirst("B");
    list.addLast("C");
    list.addFirst("A");
    list.addLast("D");
    return ExerciseSupport.format(
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithIterator(list)),
        ExerciseSupport.named("middle", list.get(2)));
  }

  /**
   * Solves Exercise 02 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addFirst("B");
    list.addLast("C");
    list.addFirst("A");
    list.addLast("D");
    return ExerciseSupport.format(
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithLoop(list)),
        ExerciseSupport.named("middle", list.get(2)));
  }

  /**
   * Solves Exercise 02 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(LinkedList<String> list) {
    list.addFirst("B");
    list.addLast("C");
    list.addFirst("A");
    list.addLast("D");
    return ExerciseSupport.format(
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithStreams(list)),
        ExerciseSupport.named("middle", list.get(2)));
  }

}
