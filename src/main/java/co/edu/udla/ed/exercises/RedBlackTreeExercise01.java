package co.edu.udla.ed.exercises;

import java.util.TreeSet;

import co.edu.udla.ed.impl.scratch.LinkedRedBlackTree;

/**
 * Exercise 01 for the Red-Black Tree series.
 *
 * <p><strong>Student task:</strong> Insert values into the tree and report the sorted traversal together with size and
 * height.</p>
 */
public final class RedBlackTreeExercise01 {

  public String solveWithCustomIterator(LinkedRedBlackTree<Integer> tree) {
    tree.insert(5);
    tree.insert(2);
    tree.insert(8);
    tree.insert(1);
    tree.insert(3);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("height", tree.height()),
        ExerciseSupport.named("inOrder", tree.inOrderIterable()));
  }

  public String solveWithJavaLoops(TreeSet<Integer> tree) {
    tree.add(5);
    tree.add(2);
    tree.add(8);
    tree.add(1);
    tree.add(3);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("height", ExerciseSupport.redBlackHeightFromValues(tree)),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotCollectionWithLoop(tree)));
  }

  public String solveWithStreams(TreeSet<Integer> tree) {
    tree.add(5);
    tree.add(2);
    tree.add(8);
    tree.add(1);
    tree.add(3);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.stream().count()),
        ExerciseSupport.named("height", ExerciseSupport.redBlackHeightFromValues(tree)),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithStreams(tree)));
  }

}
