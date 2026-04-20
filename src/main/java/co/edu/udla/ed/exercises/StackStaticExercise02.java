package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.StaticStack;

/**
 * Exercise 02 for the Static Stack series.
 *
 * <p><strong>Student task:</strong> Push values and reveal the LIFO order that the student must obtain when draining the structure.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class StackStaticExercise02 {

  /**
   * Solves Exercise 02 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(StaticStack<String> stack) {
    stack.push("uno");
    stack.push("dos");
    stack.push("tres");
    return ExerciseSupport.named("pops", ExerciseSupport.snapshotWithIterator(stack));
  }

  /**
   * Solves Exercise 02 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayDeque<String> stack) {
    stack.addLast("uno");
    stack.addLast("dos");
    stack.addLast("tres");
    return ExerciseSupport.named("pops", ExerciseSupport.stackDrainWithLoop(stack));
  }

  /**
   * Solves Exercise 02 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayDeque<String> stack) {
    stack.addLast("uno");
    stack.addLast("dos");
    stack.addLast("tres");
    return ExerciseSupport.named("pops", ExerciseSupport.stackDrainWithStreams(stack));
  }

}
