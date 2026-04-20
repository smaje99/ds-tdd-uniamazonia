package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.api.BinaryTree;
import co.edu.udla.ed.impl.scratch.LinkedBinaryTree;

public final class BinaryTreeExercise05 {

  public String solveWithCustomIterator(LinkedBinaryTree<ExerciseSupport.Learner> tree) {
    BinaryTree.Node<ExerciseSupport.Learner> root = tree.makeRoot(ExerciseSupport.learner("Ana", 101));
    BinaryTree.Node<ExerciseSupport.Learner> left = tree.attachLeft(root, ExerciseSupport.learner("Luis", 203));
    tree.attachRight(root, ExerciseSupport.learner("Mia", 305));
    tree.attachRight(left, ExerciseSupport.learner("Eva", 99));
    return ExerciseSupport.format(
        ExerciseSupport.named("preOrder", ExerciseSupport.snapshotWithIterator(tree.preOrderIterable())),
        ExerciseSupport.named("levelOrder", ExerciseSupport.snapshotWithIterator(tree.levelOrderIterable())));
  }

  public String solveWithJavaLoops(ArrayList<ExerciseSupport.Learner> tree) {
    ExerciseSupport.treeMakeRoot(tree, ExerciseSupport.learner("Ana", 101));
    int left = ExerciseSupport.treeAttachLeft(tree, 0, ExerciseSupport.learner("Luis", 203));
    ExerciseSupport.treeAttachRight(tree, 0, ExerciseSupport.learner("Mia", 305));
    ExerciseSupport.treeAttachRight(tree, left, ExerciseSupport.learner("Eva", 99));
    return ExerciseSupport.format(
        ExerciseSupport.named("preOrder", ExerciseSupport.snapshotWithLoop(ExerciseSupport.treePreOrder(tree))),
        ExerciseSupport.named("levelOrder", ExerciseSupport.snapshotWithLoop(ExerciseSupport.treeLevelOrder(tree))));
  }

  public String solveWithStreams(ArrayList<ExerciseSupport.Learner> tree) {
    ExerciseSupport.treeMakeRoot(tree, ExerciseSupport.learner("Ana", 101));
    int left = ExerciseSupport.treeAttachLeft(tree, 0, ExerciseSupport.learner("Luis", 203));
    ExerciseSupport.treeAttachRight(tree, 0, ExerciseSupport.learner("Mia", 305));
    ExerciseSupport.treeAttachRight(tree, left, ExerciseSupport.learner("Eva", 99));
    return ExerciseSupport.format(
        ExerciseSupport.named("preOrder", ExerciseSupport.snapshotWithStreams(ExerciseSupport.treePreOrder(tree))),
        ExerciseSupport.named("levelOrder", ExerciseSupport.snapshotWithStreams(ExerciseSupport.treeLevelOrder(tree))));
  }

}
