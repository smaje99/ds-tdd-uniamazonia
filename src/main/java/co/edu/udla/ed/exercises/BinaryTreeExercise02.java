package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.api.BinaryTree;
import co.edu.udla.ed.impl.scratch.LinkedBinaryTree;

public final class BinaryTreeExercise02 {

  public String solveWithCustomIterator(LinkedBinaryTree<String> tree) {
    buildSampleTree(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("height", tree.height()),
        ExerciseSupport.named("levelOrder", ExerciseSupport.snapshotWithIterator(tree.levelOrderIterable())));
  }

  public String solveWithJavaLoops(ArrayList<String> tree) {
    buildSampleTree(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("height", ExerciseSupport.treeHeight(tree)),
        ExerciseSupport.named("levelOrder", ExerciseSupport.snapshotWithLoop(ExerciseSupport.treeLevelOrder(tree))));
  }

  public String solveWithStreams(ArrayList<String> tree) {
    buildSampleTree(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("height", ExerciseSupport.treeHeight(tree)),
        ExerciseSupport.named("levelOrder", ExerciseSupport.snapshotWithStreams(ExerciseSupport.treeLevelOrder(tree))));
  }

  private void buildSampleTree(LinkedBinaryTree<String> tree) {
    BinaryTree.Node<String> root = tree.makeRoot("A");
    BinaryTree.Node<String> left = tree.attachLeft(root, "B");
    BinaryTree.Node<String> right = tree.attachRight(root, "C");
    tree.attachLeft(left, "D");
    tree.attachRight(left, "E");
    tree.attachRight(right, "F");
  }

  private void buildSampleTree(ArrayList<String> tree) {
    ExerciseSupport.treeMakeRoot(tree, "A");
    int left = ExerciseSupport.treeAttachLeft(tree, 0, "B");
    int right = ExerciseSupport.treeAttachRight(tree, 0, "C");
    ExerciseSupport.treeAttachLeft(tree, left, "D");
    ExerciseSupport.treeAttachRight(tree, left, "E");
    ExerciseSupport.treeAttachRight(tree, right, "F");
  }

}
