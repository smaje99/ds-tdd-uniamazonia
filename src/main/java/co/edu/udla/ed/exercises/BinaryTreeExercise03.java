package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.BinaryTree;

/**
 * Guided exercise 03 for the binary-tree series.
 *
 * <p>This scenario contrasts in-order and post-order traversals on the same tree. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class BinaryTreeExercise03 extends AbstractBinaryTreeStructureExercise {

  @Override
  protected String solve(BinaryTree<String> tree) {
    buildSampleTree(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshot(tree.inOrder())),
        ExerciseSupport.named("postOrder", ExerciseSupport.snapshot(tree.postOrder())));
  }

}