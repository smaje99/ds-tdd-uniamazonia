package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.DoublyLinkedList;

/**
 * Exercise 05 for the Doubly Linked List series.
 *
 * <p><strong>Student task:</strong> Use domain objects to verify equality-based membership and the final snapshot.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class DoublyLinkedListExercise05 {

  /**
   * Solves Exercise 05 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(DoublyLinkedList<ExerciseSupport.Learner> list) {
    list.addLast(ExerciseSupport.learner("Ana", 101));
    list.addLast(ExerciseSupport.learner("Luis", 203));
    list.addLast(ExerciseSupport.learner("Mia", 305));
    return ExerciseSupport.format(
        ExerciseSupport.named("middleIsLuis", list.get(1).equals(ExerciseSupport.learner("Luis", 203))),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithIterator(list)));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(LinkedList<ExerciseSupport.Learner> list) {
    list.addLast(ExerciseSupport.learner("Ana", 101));
    list.addLast(ExerciseSupport.learner("Luis", 203));
    list.addLast(ExerciseSupport.learner("Mia", 305));
    return ExerciseSupport.format(
        ExerciseSupport.named("middleIsLuis", list.get(1).equals(ExerciseSupport.learner("Luis", 203))),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithLoop(list)));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(LinkedList<ExerciseSupport.Learner> list) {
    list.addLast(ExerciseSupport.learner("Ana", 101));
    list.addLast(ExerciseSupport.learner("Luis", 203));
    list.addLast(ExerciseSupport.learner("Mia", 305));
    return ExerciseSupport.format(
        ExerciseSupport.named("middleIsLuis", list.get(1).equals(ExerciseSupport.learner("Luis", 203))),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithStreams(list)));
  }

}
