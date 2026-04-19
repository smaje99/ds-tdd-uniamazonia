package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.AVLTree;

/**
 * Guided exercise 02 for the AVL-tree series.
 *
 * <p>This scenario triggers a double rotation and reports the observable balanced state. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class AVLTreeExercise02 extends AbstractAVLTreeStructureExercise {

  @Override
  protected String solve(AVLTree<Integer> tree) {
    tree.insert(30);
    tree.insert(10);
    tree.insert(20);
    return ExerciseSupport.format(
        ExerciseSupport.named("height", tree.height()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshot(tree.inOrder())));
  }

}