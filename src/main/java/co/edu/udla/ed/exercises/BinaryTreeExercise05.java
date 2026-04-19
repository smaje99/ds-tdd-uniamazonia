package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.BinaryTree;

public final class BinaryTreeExercise05 extends AbstractBinaryTreeDomainExercise {

  @Override
  protected String solve(BinaryTree<ExerciseSupport.Learner> tree) {
    BinaryTree.Node<ExerciseSupport.Learner> root = tree.makeRoot(ExerciseSupport.learner("Ana", 101));
    BinaryTree.Node<ExerciseSupport.Learner> left = tree.attachLeft(root, ExerciseSupport.learner("Luis", 203));
    tree.attachRight(root, ExerciseSupport.learner("Mia", 305));
    tree.attachRight(left, ExerciseSupport.learner("Eva", 99));
    return ExerciseSupport.format(
        ExerciseSupport.named("preOrder", ExerciseSupport.snapshot(tree.preOrder())),
        ExerciseSupport.named("levelOrder", ExerciseSupport.snapshot(tree.levelOrder())));
  }

}
