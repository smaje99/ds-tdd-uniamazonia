package co.edu.udla.ed.exercises;

import java.util.ArrayList;
import java.util.Comparator;

import co.edu.udla.ed.common.JavaSortingAdapters;
import co.edu.udla.ed.impl.scratch.StaticSimpleList;
import co.edu.udla.ed.impl.scratch.sorting.QuickSort;

/**
 * Exercise 02 for the Sorting series.
 *
 * <p><strong>Student task:</strong> Sort a linear sequence with a custom comparator and report
 * the ordered extremes.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class SortingExercise02 {

  /**
   * Solves Exercise 02 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(StaticSimpleList<String> list) {
    list.addLast("alpha");
    list.addLast("delta");
    list.addLast("beta");
    list.addLast("gamma");
    StaticSimpleList<String> sorted = (StaticSimpleList<String>) list.sorted(new QuickSort<>(), Comparator.reverseOrder());
    return ExerciseSupport.format(
        ExerciseSupport.named("sorted", ExerciseSupport.snapshotWithIterator(sorted)),
        ExerciseSupport.named("first", sorted.get(0)),
        ExerciseSupport.named("last", sorted.get(sorted.size() - 1)));
  }

  /**
   * Solves Exercise 02 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayList<String> list) {
    list.add("alpha");
    list.add("delta");
    list.add("beta");
    list.add("gamma");
    ArrayList<String> sorted = JavaSortingAdapters.sorted(list, new QuickSort<>(), Comparator.reverseOrder());
    return ExerciseSupport.format(
        ExerciseSupport.named("sorted", ExerciseSupport.snapshotWithLoop(sorted)),
        ExerciseSupport.named("first", sorted.get(0)),
        ExerciseSupport.named("last", sorted.get(sorted.size() - 1)));
  }

  /**
   * Solves Exercise 02 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayList<String> list) {
    list.add("alpha");
    list.add("delta");
    list.add("beta");
    list.add("gamma");
    ArrayList<String> sorted = JavaSortingAdapters.sorted(list, new QuickSort<>(), Comparator.reverseOrder());
    return ExerciseSupport.format(
        ExerciseSupport.named("sorted", ExerciseSupport.snapshotWithStreams(sorted)),
        ExerciseSupport.named("first", sorted.stream().findFirst().orElseThrow()),
        ExerciseSupport.named("last", sorted.stream().skip(sorted.size() - 1L).findFirst().orElseThrow()));
  }

}
