package co.edu.udla.ed.exercises;

import java.util.TreeSet;

import co.edu.udla.ed.impl.scratch.LinkedBTree;

/**
 * Exercise 05 for the B-Tree series.
 *
 * <p><strong>Student task:</strong> Clear the tree, insert fresh values, and inspect the rebuilt state.</p>
 */
public final class BTreeExercise05 {

  public String solveWithCustomIterator(LinkedBTree<Integer> tree) {
    tree.insert(8);
    tree.insert(2);
    tree.clear();
    tree.insert(4);
    tree.insert(9);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("inOrder", tree.inOrderIterable()));
  }

  public String solveWithJavaLoops(TreeSet<Integer> tree) {
    tree.add(8);
    tree.add(2);
    tree.clear();
    tree.add(4);
    tree.add(9);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotCollectionWithLoop(tree)));
  }

  public String solveWithStreams(TreeSet<Integer> tree) {
    tree.add(8);
    tree.add(2);
    tree.clear();
    tree.add(4);
    tree.add(9);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.stream().count()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithStreams(tree)));
  }

}
