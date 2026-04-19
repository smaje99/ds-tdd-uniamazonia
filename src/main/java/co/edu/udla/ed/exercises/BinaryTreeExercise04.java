package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.BinaryTree;

public final class BinaryTreeExercise04 extends AbstractBinaryTreeStructureExercise {

  @Override
  protected String solve(BinaryTree<String> tree) {
    BinaryTree.Node<String> root = tree.makeRoot("A");
    tree.attachLeft(root, "B");
    tree.attachLeft(root, "X");
    return "unreachable";
  }

}