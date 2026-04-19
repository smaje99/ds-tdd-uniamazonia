package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.AVLTree;

public final class AVLTreeExercise03 extends AbstractAVLTreeStructureExercise {

  @Override
  protected String solve(AVLTree<Integer> tree) {
    tree.insert(3);
    tree.insert(2);
    tree.insert(4);
    tree.insert(1);
    boolean removed = tree.remove(4);
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("height", tree.height()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshot(tree.inOrder())));
  }

}