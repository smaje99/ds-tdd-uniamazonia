package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.BinarySearchTree;

import co.edu.udla.ed.impl.collections.CollectionsBinarySearchTree;
import co.edu.udla.ed.impl.linear.LinearBinarySearchTree;
import co.edu.udla.ed.impl.scratch.LinkedBinarySearchTree;

abstract class AbstractBinarySearchTreeStructureExercise extends AbstractBinarySearchTreeExercise<Integer> {

  @Override
  protected BinarySearchTree<Integer> createScratch() {
    return new LinkedBinarySearchTree<>();
  }

  @Override
  protected BinarySearchTree<Integer> createLinear() {
    return new LinearBinarySearchTree<>();
  }

  @Override
  protected BinarySearchTree<Integer> createCollections() {
    return new CollectionsBinarySearchTree<>();
  }

  protected final void insertSample(BinarySearchTree<Integer> tree) {
    tree.insert(5);
    tree.insert(2);
    tree.insert(8);
    tree.insert(1);
    tree.insert(3);
  }

}

abstract class AbstractBinarySearchTreeDomainExercise
    extends AbstractBinarySearchTreeExercise<ExerciseSupport.RankedLearner> {

  @Override
  protected BinarySearchTree<ExerciseSupport.RankedLearner> createScratch() {
    return new LinkedBinarySearchTree<>();
  }

  @Override
  protected BinarySearchTree<ExerciseSupport.RankedLearner> createLinear() {
    return new LinearBinarySearchTree<>();
  }

  @Override
  protected BinarySearchTree<ExerciseSupport.RankedLearner> createCollections() {
    return new CollectionsBinarySearchTree<>();
  }

}
