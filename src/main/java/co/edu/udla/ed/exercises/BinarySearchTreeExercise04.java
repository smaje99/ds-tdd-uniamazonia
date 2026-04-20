package co.edu.udla.ed.exercises;

import java.util.ArrayList;
import java.util.TreeSet;

import co.edu.udla.ed.impl.scratch.LinkedBinarySearchTree;

/**
 * Exercise 04 for the Binary Search Tree series.
 *
 * <p><strong>Student task:</strong> Remove the root value and report the removal result, the new size, and the updated in-order traversal.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class BinarySearchTreeExercise04 {

  /**
   * Solves Exercise 04 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(LinkedBinarySearchTree<Integer> tree) {
    insertRemovalSample(tree);
    boolean removed = tree.remove(5);
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(tree.inOrderIterable())),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithIterator(tree.inOrderIterable())));
  }

  /**
   * Solves Exercise 04 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(TreeSet<Integer> tree) {
    insertRemovalSample(tree);
    boolean removed = tree.remove(5);
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithLoop(new ArrayList<>(tree))));
  }

  /**
   * Solves Exercise 04 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(TreeSet<Integer> tree) {
    insertRemovalSample(tree);
    boolean removed = tree.remove(5);
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("size", tree.stream().count()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithStreams(tree)));
  }

  private void insertRemovalSample(LinkedBinarySearchTree<Integer> tree) {
    tree.insert(5);
    tree.insert(2);
    tree.insert(8);
    tree.insert(1);
    tree.insert(3);
    tree.insert(6);
  }

  private void insertRemovalSample(TreeSet<Integer> tree) {
    tree.add(5);
    tree.add(2);
    tree.add(8);
    tree.add(1);
    tree.add(3);
    tree.add(6);
  }

}
