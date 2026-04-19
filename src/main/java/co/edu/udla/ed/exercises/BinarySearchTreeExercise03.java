package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.BinarySearchTree;

/**
 * Guided exercise 03 for the binary-search-tree series.
 *
 * <p>This scenario removes a simpler case and reports the resulting ordered state. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class BinarySearchTreeExercise03 extends AbstractBinarySearchTreeStructureExercise {

  @Override
  protected String solve(BinarySearchTree<Integer> tree) {
    tree.insert(5);
    tree.insert(2);
    tree.insert(8);
    tree.insert(1);
    tree.insert(3);
    tree.insert(6);
    boolean removed = tree.remove(3);
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshot(tree.inOrder())));
  }

}