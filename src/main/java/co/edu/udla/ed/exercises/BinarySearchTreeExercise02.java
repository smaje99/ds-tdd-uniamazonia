package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.BinarySearchTree;

/**
 * Guided exercise 02 for the binary-search-tree series.
 *
 * <p>This scenario checks membership and size after several insertions. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class BinarySearchTreeExercise02 extends AbstractBinarySearchTreeStructureExercise {

  @Override
  protected String solve(BinarySearchTree<Integer> tree) {
    insertSample(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("contains3", tree.contains(3)),
        ExerciseSupport.named("contains7", tree.contains(7)),
        ExerciseSupport.named("size", tree.size()));
  }

}