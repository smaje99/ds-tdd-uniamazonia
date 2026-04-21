package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.common.JavaSortingAdapters;
import co.edu.udla.ed.impl.scratch.StaticSimpleList;
import co.edu.udla.ed.impl.scratch.sorting.BubbleSort;

/**
 * Exercise 01 for the Sorting series.
 *
 * <p><strong>Student task:</strong> Sort a linear sequence in ascending order and compare the
 * original snapshot with the sorted copy.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class SortingExercise01 {

  /**
   * Solves Exercise 01 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(StaticSimpleList<Integer> list) {
    list.addLast(4);
    list.addLast(1);
    list.addLast(3);
    list.addLast(2);
    StaticSimpleList<Integer> sorted = (StaticSimpleList<Integer>) list.sorted(new BubbleSort<>());
    return ExerciseSupport.format(
        ExerciseSupport.named("original", ExerciseSupport.snapshotWithIterator(list)),
        ExerciseSupport.named("sorted", ExerciseSupport.snapshotWithIterator(sorted)));
  }

  /**
   * Solves Exercise 01 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayList<Integer> list) {
    list.add(4);
    list.add(1);
    list.add(3);
    list.add(2);
    ArrayList<Integer> sorted = JavaSortingAdapters.sorted(list, new BubbleSort<>());
    return ExerciseSupport.format(
        ExerciseSupport.named("original", ExerciseSupport.snapshotWithLoop(list)),
        ExerciseSupport.named("sorted", ExerciseSupport.snapshotWithLoop(sorted)));
  }

  /**
   * Solves Exercise 01 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayList<Integer> list) {
    list.add(4);
    list.add(1);
    list.add(3);
    list.add(2);
    ArrayList<Integer> sorted = JavaSortingAdapters.sorted(list, new BubbleSort<>());
    return ExerciseSupport.format(
        ExerciseSupport.named("original", ExerciseSupport.snapshotWithStreams(list)),
        ExerciseSupport.named("sorted", ExerciseSupport.snapshotWithStreams(sorted)));
  }

}
