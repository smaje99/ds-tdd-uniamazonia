package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.common.JavaSortingAdapters;
import co.edu.udla.ed.impl.scratch.StaticSimpleList;
import co.edu.udla.ed.impl.scratch.sorting.HeapSort;

/**
 * Exercise 05 for the Sorting series.
 *
 * <p><strong>Student task:</strong> Sort domain objects with their natural order and verify that
 * the original linear structure remains unchanged.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class SortingExercise05 {

  /**
   * Solves Exercise 05 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(StaticSimpleList<ExerciseSupport.RankedLearner> list) {
    list.addLast(ExerciseSupport.rankedLearner("Ana", 2));
    list.addLast(ExerciseSupport.rankedLearner("Luis", 1));
    list.addLast(ExerciseSupport.rankedLearner("Eva", 3));
    StaticSimpleList<ExerciseSupport.RankedLearner> sorted =
        (StaticSimpleList<ExerciseSupport.RankedLearner>) list.sorted(new HeapSort<>());
    return ExerciseSupport.format(
        ExerciseSupport.named("original", ExerciseSupport.snapshotWithIterator(list)),
        ExerciseSupport.named("sorted", ExerciseSupport.snapshotWithIterator(sorted)));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayList<ExerciseSupport.RankedLearner> list) {
    list.add(ExerciseSupport.rankedLearner("Ana", 2));
    list.add(ExerciseSupport.rankedLearner("Luis", 1));
    list.add(ExerciseSupport.rankedLearner("Eva", 3));
    ArrayList<ExerciseSupport.RankedLearner> sorted = JavaSortingAdapters.sorted(list, new HeapSort<>());
    return ExerciseSupport.format(
        ExerciseSupport.named("original", ExerciseSupport.snapshotWithLoop(list)),
        ExerciseSupport.named("sorted", ExerciseSupport.snapshotWithLoop(sorted)));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayList<ExerciseSupport.RankedLearner> list) {
    list.add(ExerciseSupport.rankedLearner("Ana", 2));
    list.add(ExerciseSupport.rankedLearner("Luis", 1));
    list.add(ExerciseSupport.rankedLearner("Eva", 3));
    ArrayList<ExerciseSupport.RankedLearner> sorted = JavaSortingAdapters.sorted(list, new HeapSort<>());
    return ExerciseSupport.format(
        ExerciseSupport.named("original", ExerciseSupport.snapshotWithStreams(list)),
        ExerciseSupport.named("sorted", ExerciseSupport.snapshotWithStreams(sorted)));
  }

}
