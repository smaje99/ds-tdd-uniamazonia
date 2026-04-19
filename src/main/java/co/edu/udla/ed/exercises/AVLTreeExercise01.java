package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.AVLTree;

/**
 * Guided exercise 01 for the AVL-tree series.
 *
 * <p>This scenario triggers a single rotation and reports height together with ordered traversal. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class AVLTreeExercise01 extends AbstractAVLTreeStructureExercise {

  @Override
  protected String solve(AVLTree<Integer> tree) {
    tree.insert(30);
    tree.insert(20);
    tree.insert(10);
    return ExerciseSupport.format(
        ExerciseSupport.named("height", tree.height()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshot(tree.inOrder())));
  }

}