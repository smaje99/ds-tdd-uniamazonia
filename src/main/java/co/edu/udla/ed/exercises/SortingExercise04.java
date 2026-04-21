package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.common.JavaSortingAdapters;
import co.edu.udla.ed.impl.scratch.StaticSimpleList;
import co.edu.udla.ed.impl.scratch.sorting.CountingSort;

/**
 * Exercise 04 for the Sorting series.
 *
 * <p><strong>Student task:</strong> Use an integer-only sorting algorithm on non-negative values
 * and report the ordered result.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class SortingExercise04 {

  /**
   * Solves Exercise 04 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(StaticSimpleList<Integer> list) {
    list.addLast(4);
    list.addLast(2);
    list.addLast(0);
    list.addLast(2);
    list.addLast(1);
    StaticSimpleList<Integer> sorted = (StaticSimpleList<Integer>) list.sorted(new CountingSort());
    return ExerciseSupport.format(
        ExerciseSupport.named("sorted", ExerciseSupport.snapshotWithIterator(sorted)),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(sorted)));
  }

  /**
   * Solves Exercise 04 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayList<Integer> list) {
    list.add(4);
    list.add(2);
    list.add(0);
    list.add(2);
    list.add(1);
    ArrayList<Integer> sorted = JavaSortingAdapters.sorted(list, new CountingSort());
    return ExerciseSupport.format(
        ExerciseSupport.named("sorted", ExerciseSupport.snapshotWithLoop(sorted)),
        ExerciseSupport.named("size", sorted.size()));
  }

  /**
   * Solves Exercise 04 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayList<Integer> list) {
    list.add(4);
    list.add(2);
    list.add(0);
    list.add(2);
    list.add(1);
    ArrayList<Integer> sorted = JavaSortingAdapters.sorted(list, new CountingSort());
    return ExerciseSupport.format(
        ExerciseSupport.named("sorted", ExerciseSupport.snapshotWithStreams(sorted)),
        ExerciseSupport.named("size", sorted.stream().count()));
  }

}
