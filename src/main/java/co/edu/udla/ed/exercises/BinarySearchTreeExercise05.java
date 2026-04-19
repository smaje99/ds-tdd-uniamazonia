package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.BinarySearchTree;

/**
 * Guided exercise 05 for the binary-search-tree series.
 *
 * <p>This scenario uses comparable learner domain objects so ordering is driven by compareTo rather than primitive values. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class BinarySearchTreeExercise05 extends AbstractBinarySearchTreeDomainExercise {

  @Override
  protected String solve(BinarySearchTree<ExerciseSupport.RankedLearner> tree) {
    tree.insert(ExerciseSupport.rankedLearner("Luis", 40));
    tree.insert(ExerciseSupport.rankedLearner("Ana", 20));
    tree.insert(ExerciseSupport.rankedLearner("Mia", 60));
    tree.insert(ExerciseSupport.rankedLearner("Eva", 30));
    return ExerciseSupport.format(
        ExerciseSupport.named("containsEva", tree.contains(ExerciseSupport.rankedLearner("Eva", 30))),
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshot(tree.inOrder())));
  }

}
