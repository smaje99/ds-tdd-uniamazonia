package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.DoublyLinkedList;

/**
 * Exercise 01 for the Doubly Linked List series.
 *
 * <p><strong>Student task:</strong> Build the list by combining insertions at both ends and report the final bidirectional logical order.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class DoublyLinkedListExercise01 {

  /**
   * Solves Exercise 01 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(DoublyLinkedList<String> list) {
    list.addLast("lunes");
    list.addLast("martes");
    list.addLast("miércoles");
    list.addLast("jueves");
    return ExerciseSupport.snapshotWithIterator(list);
  }

  /**
   * Solves Exercise 01 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addLast("lunes");
    list.addLast("martes");
    list.addLast("miércoles");
    list.addLast("jueves");
    return ExerciseSupport.snapshotWithLoop(list);
  }

  /**
   * Solves Exercise 01 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(LinkedList<String> list) {
    list.addLast("lunes");
    list.addLast("martes");
    list.addLast("miércoles");
    list.addLast("jueves");
    return ExerciseSupport.snapshotWithStreams(list);
  }

}
