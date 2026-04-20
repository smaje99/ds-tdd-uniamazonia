package co.edu.udla.ed.exercises;

import java.util.ArrayList;
import java.util.TreeSet;

import co.edu.udla.ed.impl.scratch.LinkedAVLTree;

/**
 * Exercise 05 for the AVL Tree series.
 *
 * <p><strong>Student task:</strong> Use comparable domain objects to validate containment, balanced height, and sorted traversal.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class AVLTreeExercise05 {

  /**
   * Solves Exercise 05 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(LinkedAVLTree<ExerciseSupport.RankedLearner> tree) {
    tree.insert(ExerciseSupport.rankedLearner("Luis", 40));
    tree.insert(ExerciseSupport.rankedLearner("Ana", 20));
    tree.insert(ExerciseSupport.rankedLearner("Zoe", 60));
    tree.insert(ExerciseSupport.rankedLearner("Eva", 30));
    tree.insert(ExerciseSupport.rankedLearner("Ian", 10));
    return ExerciseSupport.format(
        ExerciseSupport.named("containsEva", tree.contains(ExerciseSupport.rankedLearner("Eva", 30))),
        ExerciseSupport.named("height", tree.height()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithIterator(tree.inOrderIterable())));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(TreeSet<ExerciseSupport.RankedLearner> tree) {
    tree.add(ExerciseSupport.rankedLearner("Luis", 40));
    tree.add(ExerciseSupport.rankedLearner("Ana", 20));
    tree.add(ExerciseSupport.rankedLearner("Zoe", 60));
    tree.add(ExerciseSupport.rankedLearner("Eva", 30));
    tree.add(ExerciseSupport.rankedLearner("Ian", 10));
    return ExerciseSupport.format(
        ExerciseSupport.named("containsEva", tree.contains(ExerciseSupport.rankedLearner("Eva", 30))),
        ExerciseSupport.named("height", ExerciseSupport.avlHeightFromValues(tree)),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithLoop(new ArrayList<>(tree))));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(TreeSet<ExerciseSupport.RankedLearner> tree) {
    tree.add(ExerciseSupport.rankedLearner("Luis", 40));
    tree.add(ExerciseSupport.rankedLearner("Ana", 20));
    tree.add(ExerciseSupport.rankedLearner("Zoe", 60));
    tree.add(ExerciseSupport.rankedLearner("Eva", 30));
    tree.add(ExerciseSupport.rankedLearner("Ian", 10));
    return ExerciseSupport.format(
        ExerciseSupport.named("containsEva", tree.contains(ExerciseSupport.rankedLearner("Eva", 30))),
        ExerciseSupport.named("height", ExerciseSupport.avlHeightFromValues(tree)),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithStreams(tree)));
  }

}
