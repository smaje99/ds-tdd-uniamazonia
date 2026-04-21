package co.edu.udla.ed.exercises;

import java.util.TreeSet;

import co.edu.udla.ed.impl.scratch.LinkedBTree;

/**
 * Exercise 03 for the B-Tree series.
 *
 * <p><strong>Student task:</strong> Remove values and inspect the resulting sorted traversal.</p>
 */
public final class BTreeExercise03 {

  public String solveWithCustomIterator(LinkedBTree<Integer> tree) {
    for (int value : new int[]{10, 20, 5, 6, 12, 30, 7, 17}) {
      tree.insert(value);
    }
    tree.remove(6);
    tree.remove(20);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("inOrder", tree.inOrderIterable()));
  }

  public String solveWithJavaLoops(TreeSet<Integer> tree) {
    for (int value : new int[]{10, 20, 5, 6, 12, 30, 7, 17}) {
      tree.add(value);
    }
    tree.remove(6);
    tree.remove(20);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotCollectionWithLoop(tree)));
  }

  public String solveWithStreams(TreeSet<Integer> tree) {
    for (int value : new int[]{10, 20, 5, 6, 12, 30, 7, 17}) {
      tree.add(value);
    }
    tree.remove(6);
    tree.remove(20);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.stream().count()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithStreams(tree)));
  }

}
