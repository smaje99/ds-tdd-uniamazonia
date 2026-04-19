package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.BinaryTree;

/**
 * Guided exercise 01 for the binary-tree series.
 *
 * <p>This scenario builds a fixed tree and reports the pre-order traversal. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class BinaryTreeExercise01 extends AbstractBinaryTreeStructureExercise {

  @Override
  protected String solve(BinaryTree<String> tree) {
    buildSampleTree(tree);
    return ExerciseSupport.named("preOrder", ExerciseSupport.snapshot(tree.preOrder()));
  }

}