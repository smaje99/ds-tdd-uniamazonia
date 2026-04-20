package co.edu.udla.ed.exercises;

import java.util.ArrayList;
import java.util.TreeSet;

import co.edu.udla.ed.impl.scratch.LinkedBinarySearchTree;

/**
 * Exercise 05 for the Binary Search Tree series.
 *
 * <p><strong>Student task:</strong> Use comparable domain objects to validate membership, size, and sorted traversal.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class BinarySearchTreeExercise05 {

  /**
   * Solves Exercise 05 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(LinkedBinarySearchTree<ExerciseSupport.RankedLearner> tree) {
    insertDomainSample(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("containsEva", tree.contains(ExerciseSupport.rankedLearner("Eva", 30))),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(tree.inOrderIterable())),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithIterator(tree.inOrderIterable())));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(TreeSet<ExerciseSupport.RankedLearner> tree) {
    insertDomainSample(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("containsEva", tree.contains(ExerciseSupport.rankedLearner("Eva", 30))),
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithLoop(new ArrayList<>(tree))));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(TreeSet<ExerciseSupport.RankedLearner> tree) {
    insertDomainSample(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("containsEva", tree.contains(ExerciseSupport.rankedLearner("Eva", 30))),
        ExerciseSupport.named("size", tree.stream().count()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithStreams(tree)));
  }

  private void insertDomainSample(LinkedBinarySearchTree<ExerciseSupport.RankedLearner> tree) {
    tree.insert(ExerciseSupport.rankedLearner("Luis", 40));
    tree.insert(ExerciseSupport.rankedLearner("Ana", 20));
    tree.insert(ExerciseSupport.rankedLearner("Mia", 60));
    tree.insert(ExerciseSupport.rankedLearner("Eva", 30));
  }

  private void insertDomainSample(TreeSet<ExerciseSupport.RankedLearner> tree) {
    tree.add(ExerciseSupport.rankedLearner("Luis", 40));
    tree.add(ExerciseSupport.rankedLearner("Ana", 20));
    tree.add(ExerciseSupport.rankedLearner("Mia", 60));
    tree.add(ExerciseSupport.rankedLearner("Eva", 30));
  }

}
