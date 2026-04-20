package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.impl.scratch.StaticSimpleList;

/**
 * Exercise 01 for the Static Simple List series.
 *
 * <p><strong>Student task:</strong> Build the list by combining insertions at the beginning and at the end, then report the final logical order.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class SimpleListStaticExercise01 {

  /**
   * Solves Exercise 01 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(StaticSimpleList<String> list) {
    list.addLast("B");
    list.addFirst("A");
    list.addLast("C");
    list.addFirst("inicio");
    return ExerciseSupport.snapshotWithIterator(list);
  }

  /**
   * Solves Exercise 01 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayList<String> list) {
    list.add("B");
    list.add(0, "A");
    list.add("C");
    list.add(0, "inicio");
    return ExerciseSupport.snapshotWithLoop(list);
  }

  /**
   * Solves Exercise 01 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayList<String> list) {
    list.add("B");
    list.add(0, "A");
    list.add("C");
    list.add(0, "inicio");
    return ExerciseSupport.snapshotWithStreams(list);
  }

}
