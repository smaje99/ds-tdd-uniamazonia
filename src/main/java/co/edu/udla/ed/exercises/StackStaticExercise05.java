package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.StaticStack;

/**
 * Exercise 05 for the Static Stack series.
 *
 * <p><strong>Student task:</strong> Use domain objects to validate top inspection, one removal, and the remaining LIFO order.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class StackStaticExercise05 {

  /**
   * Solves Exercise 05 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(StaticStack<ExerciseSupport.Learner> stack) {
    stack.push(ExerciseSupport.learner("Ana", 101));
    stack.push(ExerciseSupport.learner("Luis", 203));
    stack.push(ExerciseSupport.learner("Mia", 305));
    boolean topMatches = stack.peek().equals(ExerciseSupport.learner("Mia", 305));
    ExerciseSupport.Learner popped = stack.pop();
    return ExerciseSupport.format(
        ExerciseSupport.named("topMatches", topMatches),
        ExerciseSupport.named("popped", popped),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithIterator(stack)));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayDeque<ExerciseSupport.Learner> stack) {
    stack.addLast(ExerciseSupport.learner("Ana", 101));
    stack.addLast(ExerciseSupport.learner("Luis", 203));
    stack.addLast(ExerciseSupport.learner("Mia", 305));
    boolean topMatches = stack.peekLast().equals(ExerciseSupport.learner("Mia", 305));
    ExerciseSupport.Learner popped = stack.removeLast();
    return ExerciseSupport.format(
        ExerciseSupport.named("topMatches", topMatches),
        ExerciseSupport.named("popped", popped),
        ExerciseSupport.named("remaining", ExerciseSupport.stackDrainWithLoop(stack)));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayDeque<ExerciseSupport.Learner> stack) {
    stack.addLast(ExerciseSupport.learner("Ana", 101));
    stack.addLast(ExerciseSupport.learner("Luis", 203));
    stack.addLast(ExerciseSupport.learner("Mia", 305));
    boolean topMatches = stack.peekLast().equals(ExerciseSupport.learner("Mia", 305));
    ExerciseSupport.Learner popped = stack.removeLast();
    return ExerciseSupport.format(
        ExerciseSupport.named("topMatches", topMatches),
        ExerciseSupport.named("popped", popped),
        ExerciseSupport.named("remaining", ExerciseSupport.stackDrainWithStreams(stack)));
  }

}
