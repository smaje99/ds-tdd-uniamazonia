package co.edu.udla.ed.exercises;

import java.util.TreeSet;

import co.edu.udla.ed.impl.scratch.LinkedBTree;

/**
 * Exercise 02 for the B-Tree series.
 *
 * <p><strong>Student task:</strong> Insert duplicate keys and verify that the observable state remains unchanged.</p>
 */
public final class BTreeExercise02 {

  public String solveWithCustomIterator(LinkedBTree<Integer> tree) {
    tree.insert(4);
    tree.insert(4);
    tree.insert(4);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("height", tree.height()),
        ExerciseSupport.named("inOrder", tree.inOrderIterable()));
  }

  public String solveWithJavaLoops(TreeSet<Integer> tree) {
    tree.add(4);
    tree.add(4);
    tree.add(4);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("height", ExerciseSupport.bTreeHeightFromValues(tree)),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotCollectionWithLoop(tree)));
  }

  public String solveWithStreams(TreeSet<Integer> tree) {
    tree.add(4);
    tree.add(4);
    tree.add(4);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", tree.stream().count()),
        ExerciseSupport.named("height", ExerciseSupport.bTreeHeightFromValues(tree)),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithStreams(tree)));
  }

}
