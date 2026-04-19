package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.BinarySearchTree;

public final class BinarySearchTreeExercise01 extends AbstractBinarySearchTreeStructureExercise {

  @Override
  protected String solve(BinarySearchTree<Integer> tree) {
    insertSample(tree);
    return ExerciseSupport.named("inOrder", ExerciseSupport.snapshot(tree.inOrder()));
  }

}