package co.edu.udla.ed.exercises;

import java.util.TreeSet;

import co.edu.udla.ed.impl.scratch.LinkedBTree;

/**
 * Exercise 04 for the B-Tree series.
 *
 * <p><strong>Student task:</strong> Query membership for present and missing values.</p>
 */
public final class BTreeExercise04 {

  public String solveWithCustomIterator(LinkedBTree<Integer> tree) {
    for (int value : new int[]{10, 20, 5, 6, 12, 30, 7, 17}) {
      tree.insert(value);
    }
    return ExerciseSupport.format(
        ExerciseSupport.named("contains6", tree.contains(6)),
        ExerciseSupport.named("contains99", tree.contains(99)));
  }

  public String solveWithJavaLoops(TreeSet<Integer> tree) {
    for (int value : new int[]{10, 20, 5, 6, 12, 30, 7, 17}) {
      tree.add(value);
    }
    return ExerciseSupport.format(
        ExerciseSupport.named("contains6", tree.contains(6)),
        ExerciseSupport.named("contains99", tree.contains(99)));
  }

  public String solveWithStreams(TreeSet<Integer> tree) {
    for (int value : new int[]{10, 20, 5, 6, 12, 30, 7, 17}) {
      tree.add(value);
    }
    return ExerciseSupport.format(
        ExerciseSupport.named("contains6", tree.stream().anyMatch(value -> value == 6)),
        ExerciseSupport.named("contains99", tree.stream().anyMatch(value -> value == 99)));
  }

}
