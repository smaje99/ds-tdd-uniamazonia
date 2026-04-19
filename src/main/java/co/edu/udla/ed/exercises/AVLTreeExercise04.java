package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.AVLTree;

public final class AVLTreeExercise04 extends AbstractAVLTreeStructureExercise {

  @Override
  protected String solve(AVLTree<Integer> tree) {
    tree.insert(10);
    tree.insert(20);
    tree.insert(30);
    tree.insert(40);
    tree.insert(50);
    tree.insert(25);
    tree.remove(50);
    return ExerciseSupport.format(
        ExerciseSupport.named("contains25", tree.contains(25)),
        ExerciseSupport.named("height", tree.height()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshot(tree.inOrder())));
  }

}