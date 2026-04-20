package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.impl.scratch.StaticSimpleList;

/**
 * Exercise 04 for the Static Simple List series.
 *
 * <p><strong>Student task:</strong> Force a longer insertion sequence so the student can observe growth while preserving logical order.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class SimpleListStaticExercise04 {

  /**
   * Solves Exercise 04 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(StaticSimpleList<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addLast("C");
    list.addLast("D");
    list.addLast("E");
    list.addLast("F");
    list.addLast("G");
    list.addLast("H");
    list.addLast("I");
    list.addLast("J");
    list.addLast("K");
    list.addFirst("inicio-1");
    list.addFirst("inicio-2");
    return ExerciseSupport.snapshotWithIterator(list);
  }

  /**
   * Solves Exercise 04 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayList<String> list) {
    list.add("A");
    list.add("B");
    list.add("C");
    list.add("D");
    list.add("E");
    list.add("F");
    list.add("G");
    list.add("H");
    list.add("I");
    list.add("J");
    list.add("K");
    list.add(0, "inicio-1");
    list.add(0, "inicio-2");
    return ExerciseSupport.snapshotWithLoop(list);
  }

  /**
   * Solves Exercise 04 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayList<String> list) {
    list.add("A");
    list.add("B");
    list.add("C");
    list.add("D");
    list.add("E");
    list.add("F");
    list.add("G");
    list.add("H");
    list.add("I");
    list.add("J");
    list.add("K");
    list.add(0, "inicio-1");
    list.add(0, "inicio-2");
    return ExerciseSupport.snapshotWithStreams(list);
  }

}
