package co.edu.udla.ed.exercises;

import java.util.TreeSet;

import co.edu.udla.ed.impl.scratch.LinkedRedBlackTree;

/**
 * Exercise 04 for the Red-Black Tree series.
 *
 * <p><strong>Student task:</strong> Query membership for present and missing values.</p>
 */
public final class RedBlackTreeExercise04 {

  public String solveWithCustomIterator(LinkedRedBlackTree<Integer> tree) {
    for (int value : new int[]{5, 2, 8, 1, 3}) {
      tree.insert(value);
    }
    return ExerciseSupport.format(
        ExerciseSupport.named("contains3", tree.contains(3)),
        ExerciseSupport.named("contains7", tree.contains(7)));
  }

  public String solveWithJavaLoops(TreeSet<Integer> tree) {
    for (int value : new int[]{5, 2, 8, 1, 3}) {
      tree.add(value);
    }
    return ExerciseSupport.format(
        ExerciseSupport.named("contains3", tree.contains(3)),
        ExerciseSupport.named("contains7", tree.contains(7)));
  }

  public String solveWithStreams(TreeSet<Integer> tree) {
    for (int value : new int[]{5, 2, 8, 1, 3}) {
      tree.add(value);
    }
    return ExerciseSupport.format(
        ExerciseSupport.named("contains3", tree.stream().anyMatch(value -> value == 3)),
        ExerciseSupport.named("contains7", tree.stream().anyMatch(value -> value == 7)));
  }

}
