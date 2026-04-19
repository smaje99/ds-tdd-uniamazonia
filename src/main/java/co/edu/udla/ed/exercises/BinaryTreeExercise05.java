package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.BinaryTree;

/**
 * Guided exercise 05 for the binary-tree series.
 *
 * <p>This scenario uses learner domain objects so traversals can be checked with readable custom values. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
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
