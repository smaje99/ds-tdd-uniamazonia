package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.BinaryTree;

import co.edu.udla.ed.impl.collections.CollectionsBinaryTree;
import co.edu.udla.ed.impl.linear.LinearBinaryTree;
import co.edu.udla.ed.impl.scratch.LinkedBinaryTree;

abstract class AbstractBinaryTreeStructureExercise extends AbstractBinaryTreeExercise {

  @Override
  protected BinaryTree<String> createScratch() {
    return new LinkedBinaryTree<>();
  }

  @Override
  protected BinaryTree<String> createLinear() {
    return new LinearBinaryTree<>();
  }

  @Override
  protected BinaryTree<String> createCollections() {
    return new CollectionsBinaryTree<>();
  }

  protected final BinaryTree<String> buildSampleTree(BinaryTree<String> tree) {
    BinaryTree.Node<String> a = tree.makeRoot("A");
    BinaryTree.Node<String> b = tree.attachLeft(a, "B");
    BinaryTree.Node<String> c = tree.attachRight(a, "C");
    tree.attachLeft(b, "D");
    tree.attachRight(b, "E");
    tree.attachRight(c, "F");
    return tree;
  }

}

