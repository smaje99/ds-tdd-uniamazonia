package co.edu.udla.ed.exercises;

import java.util.ArrayList;
import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.CircularDoublyLinkedList;

/**
 * Exercise 03 for the Circular Doubly Linked List series.
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
public final class CircularDoublyLinkedListExercise03 {

  /**
   * Solves Exercise 03 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(CircularDoublyLinkedList<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addLast("C");
    list.addLast("D");
    java.util.List<String> removed = new ArrayList<>();
    removed.add(list.removeFirst());
    removed.add(list.removeLast());
    removed.add(list.removeFirst());
    removed.add(list.removeLast());
    list.addLast("reinicio");
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithIterator(list)));
  }

  /**
   * Solves Exercise 03 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addLast("C");
    list.addLast("D");
    java.util.List<String> removed = new ArrayList<>();
    removed.add(list.removeFirst());
    removed.add(list.removeLast());
    removed.add(list.removeFirst());
    removed.add(list.removeLast());
    list.addLast("reinicio");
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithLoop(list)));
  }

  /**
   * Solves Exercise 03 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(LinkedList<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addLast("C");
    list.addLast("D");
    java.util.List<String> removed = new ArrayList<>();
    removed.add(list.removeFirst());
    removed.add(list.removeLast());
    removed.add(list.removeFirst());
    removed.add(list.removeLast());
    list.addLast("reinicio");
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithStreams(list)));
  }

}
