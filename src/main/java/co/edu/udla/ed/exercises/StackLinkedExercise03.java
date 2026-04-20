package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.LinkedStack;

/**
 * Exercise 03 for the Linked Stack series.
 *
 * <p><strong>Student task:</strong> Interleave pushes and pops, then report the removed value, the new top, and the resulting size.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class StackLinkedExercise03 {

  /**
   * Solves Exercise 03 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(LinkedStack<String> stack) {
    stack.push("nodo-1");
    stack.push("nodo-2");
    String popped = stack.pop();
    stack.push("nodo-3");
    stack.push("nodo-4");
    stack.pop();
    return ExerciseSupport.format(
        ExerciseSupport.named("firstPop", popped),
        ExerciseSupport.named("peek", stack.peek()),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(stack)));
  }

  /**
   * Solves Exercise 03 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayDeque<String> stack) {
    stack.addLast("nodo-1");
    stack.addLast("nodo-2");
    String popped = stack.removeLast();
    stack.addLast("nodo-3");
    stack.addLast("nodo-4");
    stack.removeLast();
    return ExerciseSupport.format(
        ExerciseSupport.named("firstPop", popped),
        ExerciseSupport.named("peek", stack.peekLast()),
        ExerciseSupport.named("size", stack.size()));
  }

  /**
   * Solves Exercise 03 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayDeque<String> stack) {
    stack.addLast("nodo-1");
    stack.addLast("nodo-2");
    String popped = stack.removeLast();
    stack.addLast("nodo-3");
    stack.addLast("nodo-4");
    stack.removeLast();
    return ExerciseSupport.format(
        ExerciseSupport.named("firstPop", popped),
        ExerciseSupport.named("peek", stack.peekLast()),
        ExerciseSupport.named("size", stack.stream().count()));
  }

}
