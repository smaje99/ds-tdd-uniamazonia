package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.BinaryTree;

/**
 * Guided exercise 04 for the binary-tree series.
 *
 * <p>This scenario documents the failure case where a child is attached to an occupied side. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class BinaryTreeExercise04 extends AbstractBinaryTreeStructureExercise {

  @Override
  protected String solve(BinaryTree<String> tree) {
    BinaryTree.Node<String> root = tree.makeRoot("A");
    tree.attachLeft(root, "B");
    tree.attachLeft(root, "X");
    return "unreachable";
  }

}