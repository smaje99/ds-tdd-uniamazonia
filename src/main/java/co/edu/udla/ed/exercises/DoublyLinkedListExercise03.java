package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.DoublyLinkedList;

/**
 * Exercise 03 for the Doubly Linked List series.
 *
 * <p><strong>Student task:</strong> Insert several elements and validate indexed access together with membership checks.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class DoublyLinkedListExercise03 {

  /**
   * Solves Exercise 03 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(DoublyLinkedList<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addLast("tres");
    list.addLast("cuatro");
    list.addLast("cinco");
    return ExerciseSupport.format(
        ExerciseSupport.named("first", list.get(0)),
        ExerciseSupport.named("middle", list.get(2)),
        ExerciseSupport.named("last", list.get(4)));
  }

  /**
   * Solves Exercise 03 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addLast("tres");
    list.addLast("cuatro");
    list.addLast("cinco");
    return ExerciseSupport.format(
        ExerciseSupport.named("first", list.get(0)),
        ExerciseSupport.named("middle", list.get(2)),
        ExerciseSupport.named("last", list.get(4)));
  }

  /**
   * Solves Exercise 03 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(LinkedList<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addLast("tres");
    list.addLast("cuatro");
    list.addLast("cinco");
    return ExerciseSupport.format(
        ExerciseSupport.named("first", list.get(0)),
        ExerciseSupport.named("middle", list.get(2)),
        ExerciseSupport.named("last", list.get(4)));
  }

}
