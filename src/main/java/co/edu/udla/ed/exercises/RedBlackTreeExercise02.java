package co.edu.udla.ed.exercises;

import java.util.TreeSet;

import co.edu.udla.ed.impl.scratch.LinkedRedBlackTree;

/**
 * Exercise 02 for the Red-Black Tree series.
 *
 * <p><strong>Student task:</strong> Insert a duplicate key and verify that the observable state does not grow.</p>
 */
public final class RedBlackTreeExercise02 {

  public String solveWithCustomIterator(LinkedRedBlackTree<Integer> tree) {
    tree.insert(5);
    tree.insert(5);
    tree.insert(5);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("height", tree.height()),
        ExerciseSupport.named("inOrder", tree.inOrderIterable()));
  }

  public String solveWithJavaLoops(TreeSet<Integer> tree) {
    tree.add(5);
    tree.add(5);
    tree.add(5);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("height", ExerciseSupport.redBlackHeightFromValues(tree)),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotCollectionWithLoop(tree)));
  }

  public String solveWithStreams(TreeSet<Integer> tree) {
    tree.add(5);
    tree.add(5);
    tree.add(5);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.stream().count()),
        ExerciseSupport.named("height", ExerciseSupport.redBlackHeightFromValues(tree)),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithStreams(tree)));
  }

}
