package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.AVLTree;

import co.edu.udla.ed.impl.collections.CollectionsAVLTree;
import co.edu.udla.ed.impl.linear.LinearAVLTree;
import co.edu.udla.ed.impl.scratch.LinkedAVLTree;

abstract class AbstractAVLTreeStructureExercise extends AbstractAVLTreeExercise {

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

