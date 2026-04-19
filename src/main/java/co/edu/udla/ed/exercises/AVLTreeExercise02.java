package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.AVLTree;

public final class AVLTreeExercise02 extends AbstractAVLTreeStructureExercise {

  @Override
  protected String solve(AVLTree<Integer> tree) {
    tree.insert(30);
    tree.insert(10);
    tree.insert(20);
    return ExerciseSupport.format(
        ExerciseSupport.named("height", tree.height()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshot(tree.inOrder())));
  }

}