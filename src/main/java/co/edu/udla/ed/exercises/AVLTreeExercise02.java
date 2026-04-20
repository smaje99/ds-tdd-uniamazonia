package co.edu.udla.ed.exercises;

import java.util.ArrayList;
import java.util.TreeSet;

import co.edu.udla.ed.impl.scratch.LinkedAVLTree;

/**
 * Exercise 02 for the AVL Tree series.
 *
 * <p><strong>Student task:</strong> Trigger a double AVL rotation and report the balanced height together with the in-order traversal.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class AVLTreeExercise02 {

  /**
   * Solves Exercise 02 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(LinkedAVLTree<Integer> tree) {
    tree.insert(30);
    tree.insert(10);
    tree.insert(20);
    return ExerciseSupport.format(
        ExerciseSupport.named("height", tree.height()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithIterator(tree.inOrderIterable())));
  }

  /**
   * Solves Exercise 02 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(TreeSet<Integer> tree) {
    tree.add(30);
    tree.add(10);
    tree.add(20);
    return ExerciseSupport.format(
        ExerciseSupport.named("height", ExerciseSupport.avlHeightFromValues(tree)),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithLoop(new ArrayList<>(tree))));
  }

  /**
   * Solves Exercise 02 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(TreeSet<Integer> tree) {
    tree.add(30);
    tree.add(10);
    tree.add(20);
    return ExerciseSupport.format(
        ExerciseSupport.named("height", ExerciseSupport.avlHeightFromValues(tree)),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithStreams(tree)));
  }

}
