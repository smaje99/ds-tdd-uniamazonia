package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.BinaryTree;

/**
 * Guided exercise 02 for the binary-tree series.
 *
 * <p>This scenario highlights the repository height convention together with level-order traversal. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class BinaryTreeExercise02 extends AbstractBinaryTreeStructureExercise {

  @Override
  protected String solve(BinaryTree<String> tree) {
    buildSampleTree(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("height", tree.height()),
        ExerciseSupport.named("levelOrder", ExerciseSupport.snapshot(tree.levelOrder())));
  }

}