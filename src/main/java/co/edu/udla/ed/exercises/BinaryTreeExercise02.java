package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.BinaryTree;

public final class BinaryTreeExercise02 extends AbstractBinaryTreeStructureExercise {

  @Override
  protected String solve(BinaryTree<String> tree) {
    buildSampleTree(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("height", tree.height()),
        ExerciseSupport.named("levelOrder", ExerciseSupport.snapshot(tree.levelOrder())));
  }

}