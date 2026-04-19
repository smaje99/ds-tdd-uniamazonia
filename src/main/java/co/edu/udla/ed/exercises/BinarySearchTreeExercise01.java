package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.BinarySearchTree;

/**
 * Guided exercise 01 for the binary-search-tree series.
 *
 * <p>This scenario inserts values out of order and reports the sorted in-order traversal. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class BinarySearchTreeExercise01 extends AbstractBinarySearchTreeStructureExercise {

  @Override
  protected String solve(BinarySearchTree<Integer> tree) {
    insertSample(tree);
    return ExerciseSupport.named("inOrder", ExerciseSupport.snapshot(tree.inOrder()));
  }

}