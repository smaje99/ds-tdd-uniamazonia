package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.LinkedStack;

/**
 * Exercise 04 for the Linked Stack series.
 *
 * <p><strong>Student task:</strong> Execute a longer push sequence so the student can confirm that growth does not break LIFO behavior.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class StackLinkedExercise04 {

  /**
   * Solves Exercise 04 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(LinkedStack<String> stack) {
    stack.push("primero");
    stack.push("segundo");
    stack.push("tercero");
    stack.push("cuarto");
    stack.push("quinto");
    return ExerciseSupport.named("pops", ExerciseSupport.snapshotWithIterator(stack));
  }

  /**
   * Solves Exercise 04 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayDeque<String> stack) {
    stack.addLast("primero");
    stack.addLast("segundo");
    stack.addLast("tercero");
    stack.addLast("cuarto");
    stack.addLast("quinto");
    return ExerciseSupport.named("pops", ExerciseSupport.stackDrainWithLoop(stack));
  }

  /**
   * Solves Exercise 04 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayDeque<String> stack) {
    stack.addLast("primero");
    stack.addLast("segundo");
    stack.addLast("tercero");
    stack.addLast("cuarto");
    stack.addLast("quinto");
    return ExerciseSupport.named("pops", ExerciseSupport.stackDrainWithStreams(stack));
  }

}
