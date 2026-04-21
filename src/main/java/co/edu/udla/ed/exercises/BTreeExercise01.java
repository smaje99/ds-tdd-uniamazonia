package co.edu.udla.ed.exercises;

import java.util.TreeSet;

import co.edu.udla.ed.impl.scratch.LinkedBTree;

/**
 * Exercise 01 for the B-Tree series.
 *
 * <p><strong>Student task:</strong> Insert values into the tree and report the sorted traversal together with size and
 * height.</p>
 */
public final class BTreeExercise01 {

  public String solveWithCustomIterator(LinkedBTree<Integer> tree) {
    for (int value : new int[]{10, 20, 5, 6, 12, 30, 7, 17}) {
      tree.insert(value);
    }
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("height", tree.height()),
        ExerciseSupport.named("inOrder", tree.inOrderIterable()));
  }

  public String solveWithJavaLoops(TreeSet<Integer> tree) {
    for (int value : new int[]{10, 20, 5, 6, 12, 30, 7, 17}) {
      tree.add(value);
    }
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("height", ExerciseSupport.bTreeHeightFromValues(tree)),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotCollectionWithLoop(tree)));
  }

  public String solveWithStreams(TreeSet<Integer> tree) {
    for (int value : new int[]{10, 20, 5, 6, 12, 30, 7, 17}) {
      tree.add(value);
    }
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.stream().count()),
        ExerciseSupport.named("height", ExerciseSupport.bTreeHeightFromValues(tree)),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithStreams(tree)));
  }

}
