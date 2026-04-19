package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.AVLTree;
import co.edu.udla.ed.api.BinarySearchTree;
import co.edu.udla.ed.api.BinaryTree;
import co.edu.udla.ed.api.Graph;
import co.edu.udla.ed.api.HashTable;
import co.edu.udla.ed.api.List;
import co.edu.udla.ed.api.Queue;
import co.edu.udla.ed.api.Stack;

abstract class AbstractListExercise implements ExerciseCase {

  protected abstract List<String> createScratch();

  protected abstract List<String> createLinear();

  protected abstract List<String> createCollections();

  protected abstract String solve(List<String> list);

  @Override
  public final String solveWithScratch() {
    return solve(createScratch());
  }

  @Override
  public final String solveWithLinear() {
    return solve(createLinear());
  }

  @Override
  public final String solveWithCollections() {
    return solve(createCollections());
  }

}

abstract class AbstractStackExercise implements ExerciseCase {

  protected abstract Stack<String> createScratch();

  protected abstract Stack<String> createLinear();

  protected abstract Stack<String> createCollections();

  protected abstract String solve(Stack<String> stack);

  @Override
  public final String solveWithScratch() {
    return solve(createScratch());
  }

  @Override
  public final String solveWithLinear() {
    return solve(createLinear());
  }

  @Override
  public final String solveWithCollections() {
    return solve(createCollections());
  }

}

abstract class AbstractQueueExercise implements ExerciseCase {

  protected abstract Queue<String> createScratch();

  protected abstract Queue<String> createLinear();

  protected abstract Queue<String> createCollections();

  protected abstract String solve(Queue<String> queue);

  @Override
  public final String solveWithScratch() {
    return solve(createScratch());
  }

  @Override
  public final String solveWithLinear() {
    return solve(createLinear());
  }

  @Override
  public final String solveWithCollections() {
    return solve(createCollections());
  }

}

abstract class AbstractBinaryTreeExercise implements ExerciseCase {

  protected abstract BinaryTree<String> createScratch();

  protected abstract BinaryTree<String> createLinear();

  protected abstract BinaryTree<String> createCollections();

  protected abstract String solve(BinaryTree<String> tree);

  @Override
  public final String solveWithScratch() {
    return solve(createScratch());
  }

  @Override
  public final String solveWithLinear() {
    return solve(createLinear());
  }

  @Override
  public final String solveWithCollections() {
    return solve(createCollections());
  }

}

abstract class AbstractBinarySearchTreeExercise implements ExerciseCase {

  protected abstract BinarySearchTree<Integer> createScratch();

  protected abstract BinarySearchTree<Integer> createLinear();

  protected abstract BinarySearchTree<Integer> createCollections();

  protected abstract String solve(BinarySearchTree<Integer> tree);

  @Override
  public final String solveWithScratch() {
    return solve(createScratch());
  }

  @Override
  public final String solveWithLinear() {
    return solve(createLinear());
  }

  @Override
  public final String solveWithCollections() {
    return solve(createCollections());
  }

}

abstract class AbstractAVLTreeExercise implements ExerciseCase {

  protected abstract AVLTree<Integer> createScratch();

  protected abstract AVLTree<Integer> createLinear();

  protected abstract AVLTree<Integer> createCollections();

  protected abstract String solve(AVLTree<Integer> tree);

  @Override
  public final String solveWithScratch() {
    return solve(createScratch());
  }

  @Override
  public final String solveWithLinear() {
    return solve(createLinear());
  }

  @Override
  public final String solveWithCollections() {
    return solve(createCollections());
  }

}

abstract class AbstractGraphExercise implements ExerciseCase {

  protected abstract Graph<String> createScratch();

  protected abstract Graph<String> createLinear();

  protected abstract Graph<String> createCollections();

  protected abstract String solve(Graph<String> graph);

  @Override
  public final String solveWithScratch() {
    return solve(createScratch());
  }

  @Override
  public final String solveWithLinear() {
    return solve(createLinear());
  }

  @Override
  public final String solveWithCollections() {
    return solve(createCollections());
  }

}

abstract class AbstractHashTableExercise<K> implements ExerciseCase {

  protected abstract HashTable<K, Integer> createScratch();

  protected abstract HashTable<K, Integer> createLinear();

  protected abstract HashTable<K, Integer> createCollections();

  protected abstract String solve(HashTable<K, Integer> table);

  @Override
  public final String solveWithScratch() {
    return solve(createScratch());
  }

  @Override
  public final String solveWithLinear() {
    return solve(createLinear());
  }

  @Override
  public final String solveWithCollections() {
    return solve(createCollections());
  }

}
