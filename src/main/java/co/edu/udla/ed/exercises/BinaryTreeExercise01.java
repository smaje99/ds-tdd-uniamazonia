package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.api.BinaryTree;
import co.edu.udla.ed.impl.scratch.LinkedBinaryTree;

/**
 * Exercise 01 for the Binary Tree series.
 *
 * <p><strong>Student task:</strong> Build a small binary tree and report its pre-order traversal.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class BinaryTreeExercise01 {

  /**
   * Solves Exercise 01 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(LinkedBinaryTree<String> tree) {
    buildSampleTree(tree);
    return ExerciseSupport.named("preOrder", ExerciseSupport.snapshotWithIterator(tree.preOrderIterable()));
  }

  /**
   * Solves Exercise 01 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayList<String> tree) {
    buildSampleTree(tree);
    return ExerciseSupport.named("preOrder", ExerciseSupport.snapshotWithLoop(ExerciseSupport.treePreOrder(tree)));
  }

  /**
   * Solves Exercise 01 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayList<String> tree) {
    buildSampleTree(tree);
    return ExerciseSupport.named("preOrder", ExerciseSupport.snapshotWithStreams(ExerciseSupport.treePreOrder(tree)));
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
