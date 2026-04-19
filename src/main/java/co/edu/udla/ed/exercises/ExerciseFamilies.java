package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.AVLTree;
import co.edu.udla.ed.api.BinarySearchTree;
import co.edu.udla.ed.api.BinaryTree;
import co.edu.udla.ed.api.Graph;
import co.edu.udla.ed.api.HashTable;
import co.edu.udla.ed.api.List;
import co.edu.udla.ed.api.Queue;
import co.edu.udla.ed.api.Stack;

import java.util.ArrayList;

abstract class AbstractListExercise<T> implements ExerciseCase {

  protected abstract List<T> createScratch();

  protected abstract List<T> createLinear();

  protected abstract List<T> createCollections();

  protected abstract String solve(List<T> list);

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

abstract class AbstractStackExercise<T> implements ExerciseCase {

  protected abstract Stack<T> createScratch();

  protected abstract Stack<T> createLinear();

  protected abstract Stack<T> createCollections();

  protected abstract String solve(Stack<T> stack);

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

  protected final String popAll(Stack<T> stack) {
    java.util.List<T> values = new ArrayList<>();
    while (!stack.isEmpty()) {
      values.add(stack.pop());
    }
    return values.toString();
  }

}

abstract class AbstractQueueExercise<T> implements ExerciseCase {

  protected abstract Queue<T> createScratch();

  protected abstract Queue<T> createLinear();

  protected abstract Queue<T> createCollections();

  protected abstract String solve(Queue<T> queue);

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

  protected final String dequeueAll(Queue<T> queue) {
    java.util.List<T> values = new ArrayList<>();
    while (!queue.isEmpty()) {
      values.add(queue.dequeue());
    }
    return values.toString();
  }

}

abstract class AbstractBinaryTreeExercise<T> implements ExerciseCase {

  protected abstract BinaryTree<T> createScratch();

  protected abstract BinaryTree<T> createLinear();

  protected abstract BinaryTree<T> createCollections();

  protected abstract String solve(BinaryTree<T> tree);

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

abstract class AbstractBinarySearchTreeExercise<T extends Comparable<T>> implements ExerciseCase {

  protected abstract BinarySearchTree<T> createScratch();

  protected abstract BinarySearchTree<T> createLinear();

  protected abstract BinarySearchTree<T> createCollections();

  protected abstract String solve(BinarySearchTree<T> tree);

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

abstract class AbstractAVLTreeExercise<T extends Comparable<T>> implements ExerciseCase {

  protected abstract AVLTree<T> createScratch();

  protected abstract AVLTree<T> createLinear();

  protected abstract AVLTree<T> createCollections();

  protected abstract String solve(AVLTree<T> tree);

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

abstract class AbstractGraphExercise<V> implements ExerciseCase {

  protected abstract Graph<V> createScratch();

  protected abstract Graph<V> createLinear();

  protected abstract Graph<V> createCollections();

  protected abstract String solve(Graph<V> graph);

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

abstract class AbstractHashTableExercise<K, V> implements ExerciseCase {

  protected abstract HashTable<K, V> createScratch();

  protected abstract HashTable<K, V> createLinear();

  protected abstract HashTable<K, V> createCollections();

  protected abstract String solve(HashTable<K, V> table);

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
