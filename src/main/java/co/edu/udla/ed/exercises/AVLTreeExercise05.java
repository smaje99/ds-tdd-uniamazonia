package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.AVLTree;

/**
 * Guided exercise 05 for the AVL-tree series.
 *
 * <p>This scenario uses comparable learner domain objects so balancing can be observed with custom ordered values. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class AVLTreeExercise05 extends AbstractAVLTreeDomainExercise {

  @Override
  protected String solve(AVLTree<ExerciseSupport.RankedLearner> tree) {
    tree.insert(ExerciseSupport.rankedLearner("Luis", 40));
    tree.insert(ExerciseSupport.rankedLearner("Ana", 20));
    tree.insert(ExerciseSupport.rankedLearner("Zoe", 60));
    tree.insert(ExerciseSupport.rankedLearner("Eva", 30));
    tree.insert(ExerciseSupport.rankedLearner("Ian", 10));
    return ExerciseSupport.format(
        ExerciseSupport.named("containsEva", tree.contains(ExerciseSupport.rankedLearner("Eva", 30))),
        ExerciseSupport.named("height", tree.height()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshot(tree.inOrder())));
  }

}
