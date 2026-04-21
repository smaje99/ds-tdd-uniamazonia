package co.edu.udla.ed.exercises;

import java.util.TreeSet;

import co.edu.udla.ed.impl.scratch.LinkedRedBlackTree;

/**
 * Exercise 03 for the Red-Black Tree series.
 *
 * <p><strong>Student task:</strong> Remove values from the tree and inspect the resulting sorted traversal.</p>
 */
public final class RedBlackTreeExercise03 {

  public String solveWithCustomIterator(LinkedRedBlackTree<Integer> tree) {
    for (int value : new int[]{10, 5, 15, 3, 7, 12, 18}) {
      tree.insert(value);
    }
    tree.remove(3);
    tree.remove(10);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("inOrder", tree.inOrderIterable()));
  }

  public String solveWithJavaLoops(TreeSet<Integer> tree) {
    for (int value : new int[]{10, 5, 15, 3, 7, 12, 18}) {
      tree.add(value);
    }
    tree.remove(3);
    tree.remove(10);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotCollectionWithLoop(tree)));
  }

  public String solveWithStreams(TreeSet<Integer> tree) {
    for (int value : new int[]{10, 5, 15, 3, 7, 12, 18}) {
      tree.add(value);
    }
    tree.remove(3);
    tree.remove(10);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.stream().count()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithStreams(tree)));
  }

}
