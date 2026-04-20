package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.StaticStack;

/**
 * Exercise 03 for the Static Stack series.
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
public final class StackStaticExercise03 {

  /**
   * Solves Exercise 03 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(StaticStack<String> stack) {
    stack.push("A");
    stack.push("B");
    String popped = stack.pop();
    stack.push("C");
    return ExerciseSupport.format(
        ExerciseSupport.named("popped", popped),
        ExerciseSupport.named("peek", stack.peek()),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(stack)));
  }

  /**
   * Solves Exercise 03 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayDeque<String> stack) {
    stack.addLast("A");
    stack.addLast("B");
    String popped = stack.removeLast();
    stack.addLast("C");
    return ExerciseSupport.format(
        ExerciseSupport.named("popped", popped),
        ExerciseSupport.named("peek", stack.peekLast()),
        ExerciseSupport.named("size", stack.size()));
  }

  /**
   * Solves Exercise 03 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayDeque<String> stack) {
    stack.addLast("A");
    stack.addLast("B");
    String popped = stack.removeLast();
    stack.addLast("C");
    return ExerciseSupport.format(
        ExerciseSupport.named("popped", popped),
        ExerciseSupport.named("peek", stack.peekLast()),
        ExerciseSupport.named("size", stack.stream().count()));
  }

}
