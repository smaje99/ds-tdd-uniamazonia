package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.api.BinaryTree;
import co.edu.udla.ed.impl.scratch.LinkedBinaryTree;

public final class BinaryTreeExercise04 {

  public String solveWithCustomIterator(LinkedBinaryTree<String> tree) {
    BinaryTree.Node<String> root = tree.makeRoot("A");
    tree.attachLeft(root, "B");
    tree.attachLeft(root, "X");
    return "unreachable";
  }

  public String solveWithJavaLoops(ArrayList<String> tree) {
    ExerciseSupport.treeMakeRoot(tree, "A");
    ExerciseSupport.treeAttachLeft(tree, 0, "B");
    ExerciseSupport.treeAttachLeft(tree, 0, "X");
    return "unreachable";
  }

  public String solveWithStreams(ArrayList<String> tree) {
    ExerciseSupport.treeMakeRoot(tree, "A");
    ExerciseSupport.treeAttachLeft(tree, 0, "B");
    ExerciseSupport.treeAttachLeft(tree, 0, "X");
    return "unreachable";
  }

}
