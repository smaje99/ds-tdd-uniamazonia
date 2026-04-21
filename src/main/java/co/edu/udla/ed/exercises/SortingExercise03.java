package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.common.JavaSortingAdapters;
import co.edu.udla.ed.impl.scratch.StaticSimpleList;
import co.edu.udla.ed.impl.scratch.sorting.MergeSort;

/**
 * Exercise 03 for the Sorting series.
 *
 * <p><strong>Student task:</strong> Sort a sequence with duplicates and count the repeated values
 * in the final ordered snapshot.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class SortingExercise03 {

  /**
   * Solves Exercise 03 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(StaticSimpleList<Integer> list) {
    list.addLast(5);
    list.addLast(1);
    list.addLast(5);
    list.addLast(3);
    list.addLast(1);
    StaticSimpleList<Integer> sorted = (StaticSimpleList<Integer>) list.sorted(new MergeSort<>());
    return ExerciseSupport.format(
        ExerciseSupport.named("sorted", ExerciseSupport.snapshotWithIterator(sorted)),
        ExerciseSupport.named("countOf1", countWithIterator(sorted, 1)));
  }

  /**
   * Solves Exercise 03 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayList<Integer> list) {
    list.add(5);
    list.add(1);
    list.add(5);
    list.add(3);
    list.add(1);
    ArrayList<Integer> sorted = JavaSortingAdapters.sorted(list, new MergeSort<>());
    int countOf1 = 0;
    for (int i = 0; i < sorted.size(); i++) {
      if (sorted.get(i) == 1) {
        countOf1++;
      }
    }
    return ExerciseSupport.format(
        ExerciseSupport.named("sorted", ExerciseSupport.snapshotWithLoop(sorted)),
        ExerciseSupport.named("countOf1", countOf1));
  }

  /**
   * Solves Exercise 03 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayList<Integer> list) {
    list.add(5);
    list.add(1);
    list.add(5);
    list.add(3);
    list.add(1);
    ArrayList<Integer> sorted = JavaSortingAdapters.sorted(list, new MergeSort<>());
    return ExerciseSupport.format(
        ExerciseSupport.named("sorted", ExerciseSupport.snapshotWithStreams(sorted)),
        ExerciseSupport.named("countOf1", sorted.stream().filter(value -> value == 1).count()));
  }

  private int countWithIterator(StaticSimpleList<Integer> values, int target) {
    int count = 0;
    for (Integer value : values) {
      if (value == target) {
        count++;
      }
    }
    return count;
  }

}
