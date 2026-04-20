package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.LinkedStack;

/**
 * Exercise 01 for the Linked Stack series.
 *
 * <p><strong>Student task:</strong> Push several values, observe the element at the top, and report the current size.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class StackLinkedExercise01 {

  /**
   * Solves Exercise 01 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(LinkedStack<String> stack) {
    stack.push("rojo");
    stack.push("verde");
    stack.push("azul");
    return ExerciseSupport.format(
        ExerciseSupport.named("peek", stack.peek()),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(stack)));
  }

  /**
   * Solves Exercise 01 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayDeque<String> stack) {
    stack.addLast("rojo");
    stack.addLast("verde");
    stack.addLast("azul");
    return ExerciseSupport.format(
        ExerciseSupport.named("peek", stack.peekLast()),
        ExerciseSupport.named("size", stack.size()));
  }

  /**
   * Solves Exercise 01 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayDeque<String> stack) {
    stack.addLast("rojo");
    stack.addLast("verde");
    stack.addLast("azul");
    return ExerciseSupport.format(
        ExerciseSupport.named("peek", stack.peekLast()),
        ExerciseSupport.named("size", stack.stream().count()));
  }

}
