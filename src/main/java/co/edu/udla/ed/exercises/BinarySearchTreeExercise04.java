package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.BinarySearchTree;

public final class BinarySearchTreeExercise04 extends AbstractBinarySearchTreeStructureExercise {

  @Override
  protected String solve(BinarySearchTree<Integer> tree) {
    tree.insert(5);
    tree.insert(2);
    tree.insert(8);
    tree.insert(1);
    tree.insert(3);
    tree.insert(6);
    boolean removed = tree.remove(5);
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshot(tree.inOrder())));
  }

}