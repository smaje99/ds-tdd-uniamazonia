package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.BinaryTree;

public final class BinaryTreeExercise03 extends AbstractBinaryTreeStructureExercise {

  @Override
  protected String solve(BinaryTree<String> tree) {
    buildSampleTree(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshot(tree.inOrder())),
        ExerciseSupport.named("postOrder", ExerciseSupport.snapshot(tree.postOrder())));
  }

}