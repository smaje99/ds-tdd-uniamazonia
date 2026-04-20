package co.edu.udla.ed.exercises;

import java.util.TreeSet;

import co.edu.udla.ed.impl.scratch.LinkedBinarySearchTree;

/**
 * Exercise 02 for the Binary Search Tree series.
 *
 * <p><strong>Student task:</strong> Insert values and validate ordered lookup together with the current size.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class BinarySearchTreeExercise02 {

  /**
   * Solves Exercise 02 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(LinkedBinarySearchTree<Integer> tree) {
    insertSample(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("contains3", tree.contains(3)),
        ExerciseSupport.named("contains7", tree.contains(7)),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(tree.inOrderIterable())));
  }

  /**
   * Solves Exercise 02 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(TreeSet<Integer> tree) {
    insertSample(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("contains3", tree.contains(3)),
        ExerciseSupport.named("contains7", tree.contains(7)),
        ExerciseSupport.named("size", tree.size()));
  }

  /**
   * Solves Exercise 02 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(TreeSet<Integer> tree) {
    insertSample(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("contains3", tree.contains(3)),
        ExerciseSupport.named("contains7", tree.contains(7)),
        ExerciseSupport.named("size", tree.stream().count()));
  }

  private void insertSample(LinkedBinarySearchTree<Integer> tree) {
    tree.insert(5);
    tree.insert(2);
    tree.insert(8);
    tree.insert(1);
    tree.insert(3);
  }

  private void insertSample(TreeSet<Integer> tree) {
    tree.add(5);
    tree.add(2);
    tree.add(8);
    tree.add(1);
    tree.add(3);
  }

}
