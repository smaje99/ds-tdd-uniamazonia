package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.AVLTree;

import co.edu.udla.ed.impl.collections.CollectionsAVLTree;
import co.edu.udla.ed.impl.linear.LinearAVLTree;
import co.edu.udla.ed.impl.scratch.LinkedAVLTree;

/**
 * Base wiring for the AVL-tree exercise series that uses integer values.
 */
abstract class AbstractAVLTreeStructureExercise extends AbstractAVLTreeExercise<Integer> {

  @Override
  protected AVLTree<Integer> createScratch() {
    return new LinkedAVLTree<>();
  }

  @Override
  protected AVLTree<Integer> createLinear() {
    return new LinearAVLTree<>();
  }

  @Override
  protected AVLTree<Integer> createCollections() {
    return new CollectionsAVLTree<>();
  }

}

/**
 * Base wiring for the AVL-tree exercise series that uses comparable learner objects.
 */
abstract class AbstractAVLTreeDomainExercise extends AbstractAVLTreeExercise<ExerciseSupport.RankedLearner> {

  @Override
  protected AVLTree<ExerciseSupport.RankedLearner> createScratch() {
    return new LinkedAVLTree<>();
  }

  @Override
  protected AVLTree<ExerciseSupport.RankedLearner> createLinear() {
    return new LinearAVLTree<>();
  }

  @Override
  protected AVLTree<ExerciseSupport.RankedLearner> createCollections() {
    return new CollectionsAVLTree<>();
  }

}
