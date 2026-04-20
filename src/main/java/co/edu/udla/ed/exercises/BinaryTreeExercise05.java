package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.api.BinaryTree;
import co.edu.udla.ed.impl.scratch.LinkedBinaryTree;

/**
 * Exercise 05 for the Binary Tree series.
 *
 * <p><strong>Student task:</strong> Build a binary tree with domain objects and report structural properties together with a traversal snapshot.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class BinaryTreeExercise05 {

  /**
   * Solves Exercise 05 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(LinkedBinaryTree<ExerciseSupport.Learner> tree) {
    BinaryTree.Node<ExerciseSupport.Learner> root = tree.makeRoot(ExerciseSupport.learner("Ana", 101));
    BinaryTree.Node<ExerciseSupport.Learner> left = tree.attachLeft(root, ExerciseSupport.learner("Luis", 203));
    tree.attachRight(root, ExerciseSupport.learner("Mia", 305));
    tree.attachRight(left, ExerciseSupport.learner("Eva", 99));
    return ExerciseSupport.format(
        ExerciseSupport.named("preOrder", ExerciseSupport.snapshotWithIterator(tree.preOrderIterable())),
        ExerciseSupport.named("levelOrder", ExerciseSupport.snapshotWithIterator(tree.levelOrderIterable())));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayList<ExerciseSupport.Learner> tree) {
    ExerciseSupport.treeMakeRoot(tree, ExerciseSupport.learner("Ana", 101));
    int left = ExerciseSupport.treeAttachLeft(tree, 0, ExerciseSupport.learner("Luis", 203));
    ExerciseSupport.treeAttachRight(tree, 0, ExerciseSupport.learner("Mia", 305));
    ExerciseSupport.treeAttachRight(tree, left, ExerciseSupport.learner("Eva", 99));
    return ExerciseSupport.format(
        ExerciseSupport.named("preOrder", ExerciseSupport.snapshotWithLoop(ExerciseSupport.treePreOrder(tree))),
        ExerciseSupport.named("levelOrder", ExerciseSupport.snapshotWithLoop(ExerciseSupport.treeLevelOrder(tree))));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
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
