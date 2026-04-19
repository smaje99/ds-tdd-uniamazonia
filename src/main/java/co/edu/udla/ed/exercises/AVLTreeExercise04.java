package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.AVLTree;

/**
 * Guided exercise 04 for the AVL-tree series.
 *
 * <p>This scenario combines several insertions and one removal to show a larger balanced result. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class AVLTreeExercise04 extends AbstractAVLTreeStructureExercise {

  @Override
  protected String solve(AVLTree<Integer> tree) {
    tree.insert(10);
    tree.insert(20);
    tree.insert(30);
    tree.insert(40);
    tree.insert(50);
    tree.insert(25);
    tree.remove(50);
    return ExerciseSupport.format(
        ExerciseSupport.named("contains25", tree.contains(25)),
        ExerciseSupport.named("height", tree.height()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshot(tree.inOrder())));
  }

}