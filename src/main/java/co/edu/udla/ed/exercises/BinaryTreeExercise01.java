package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.BinaryTree;

public final class BinaryTreeExercise01 extends AbstractBinaryTreeStructureExercise {

  @Override
  protected String solve(BinaryTree<String> tree) {
    buildSampleTree(tree);
    return ExerciseSupport.named("preOrder", ExerciseSupport.snapshot(tree.preOrder()));
  }

}