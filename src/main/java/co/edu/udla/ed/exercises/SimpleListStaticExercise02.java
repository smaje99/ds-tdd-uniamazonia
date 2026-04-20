package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.impl.scratch.StaticSimpleList;

/**
 * Exercise 02 for the Static Simple List series.
 *
 * <p><strong>Student task:</strong> Populate the list, remove the first and last elements, and report both removed values plus the remaining sequence.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class SimpleListStaticExercise02 {

  /**
   * Solves Exercise 02 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(StaticSimpleList<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addLast("tres");
    list.addLast("cuatro");
    String removedFirst = list.removeFirst();
    String removedLast = list.removeLast();
    return ExerciseSupport.format(
        ExerciseSupport.named("removedFirst", removedFirst),
        ExerciseSupport.named("removedLast", removedLast),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithIterator(list)));
  }

  /**
   * Solves Exercise 02 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayList<String> list) {
    list.add("uno");
    list.add("dos");
    list.add("tres");
    list.add("cuatro");
    String removedFirst = list.remove(0);
    String removedLast = list.remove(list.size() - 1);
    return ExerciseSupport.format(
        ExerciseSupport.named("removedFirst", removedFirst),
        ExerciseSupport.named("removedLast", removedLast),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithLoop(list)));
  }

  /**
   * Solves Exercise 02 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayList<String> list) {
    list.add("uno");
    list.add("dos");
    list.add("tres");
    list.add("cuatro");
    String removedFirst = list.remove(0);
    String removedLast = list.remove(list.size() - 1);
    return ExerciseSupport.format(
        ExerciseSupport.named("removedFirst", removedFirst),
        ExerciseSupport.named("removedLast", removedLast),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithStreams(list)));
  }

}
