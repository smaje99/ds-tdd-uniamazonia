package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.StaticStack;

/**
 * Exercise 04 for the Static Stack series.
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
public final class StackStaticExercise04 {

  /**
   * Solves Exercise 04 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(StaticStack<String> stack) {
    for (int i = 0; i <= 11; i++) {
      stack.push(String.valueOf(i));
    }
    return ExerciseSupport.named("pops", ExerciseSupport.snapshotWithIterator(stack));
  }

  /**
   * Solves Exercise 04 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayDeque<String> stack) {
    for (int i = 0; i <= 11; i++) {
      stack.addLast(String.valueOf(i));
    }
    return ExerciseSupport.named("pops", ExerciseSupport.stackDrainWithLoop(stack));
  }

  /**
   * Solves Exercise 04 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayDeque<String> stack) {
    for (int i = 0; i <= 11; i++) {
      stack.addLast(String.valueOf(i));
    }
    return ExerciseSupport.named("pops", ExerciseSupport.stackDrainWithStreams(stack));
  }

}
