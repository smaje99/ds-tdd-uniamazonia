package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.api.BinaryTree;
import co.edu.udla.ed.impl.scratch.LinkedBinaryTree;

/**
 * Exercise 04 for the Binary Tree series.
 *
 * <p><strong>Student task:</strong> Attempt to attach a second left child to the same parent and observe the expected exception.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class BinaryTreeExercise04 {

  /**
   * Solves Exercise 04 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(LinkedBinaryTree<String> tree) {
    BinaryTree.Node<String> root = tree.makeRoot("A");
    tree.attachLeft(root, "B");
    tree.attachLeft(root, "X");
    return "unreachable";
  }

  /**
   * Solves Exercise 04 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayList<String> tree) {
    ExerciseSupport.treeMakeRoot(tree, "A");
    ExerciseSupport.treeAttachLeft(tree, 0, "B");
    ExerciseSupport.treeAttachLeft(tree, 0, "X");
    return "unreachable";
  }

  /**
   * Solves Exercise 04 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayList<String> tree) {
    ExerciseSupport.treeMakeRoot(tree, "A");
    ExerciseSupport.treeAttachLeft(tree, 0, "B");
    ExerciseSupport.treeAttachLeft(tree, 0, "X");
    return "unreachable";
  }

}
