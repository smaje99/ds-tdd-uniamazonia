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

/**
 * Base template for list-oriented exercises.
 *
 * <p>The subclass chooses the three concrete list implementations and provides a scenario-specific
 * {@link #solve(List)} method. The three public entry points stay identical so tests can compare
 * behavior across implementations without duplicating setup code.</p>
 *
 * @param <T> element type used by the exercise
 */
abstract class AbstractListExercise<T> implements ExerciseCase {

  /**
   * Creates the scratch list used in the course implementation.
   *
   * @return a fresh empty scratch list
   */
  protected abstract List<T> createScratch();

  /**
   * Creates the linear reference list.
   *
   * @return a fresh empty linear list
   */
  protected abstract List<T> createLinear();

  /**
   * Creates the collections-backed list.
   *
   * @return a fresh empty collections-based list
   */
  protected abstract List<T> createCollections();

  /**
   * Runs the exercise scenario on the provided list.
   *
   * @param list the list instance that must execute the scripted sequence
   * @return a normalized feedback string for tests and student feedback
   */
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

/**
 * Base template for stack-oriented exercises.
 *
 * <p>Besides delegating structure creation to subclasses, this family centralizes the
 * stack-draining utility used by several exercises to expose the final LIFO order as a plain
 * string.</p>
 *
 * @param <T> element type used by the exercise
 */
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

  /**
   * Pops every remaining element and returns the observed removal order.
   *
   * <p>This helper is useful in educational exercises because it converts the final LIFO state into
   * a simple snapshot that can be asserted in tests.</p>
   *
   * @param stack the stack to drain
   * @return the list-like textual representation of the pop order
   */
  protected final String popAll(Stack<T> stack) {
    java.util.List<T> values = new ArrayList<>();
    while (!stack.isEmpty()) {
      values.add(stack.pop());
    }
    return values.toString();
  }

}

/**
 * Base template for queue-oriented exercises.
 *
 * <p>The queue family mirrors the stack family, but the helper method exposes FIFO behavior by
 * dequeuing all remaining elements in logical front-to-rear order.</p>
 *
 * @param <T> element type used by the exercise
 */
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

  /**
   * Dequeues every remaining element and returns the observed service order.
   *
   * @param queue the queue to drain
   * @return the list-like textual representation of the dequeue order
   */
  protected final String dequeueAll(Queue<T> queue) {
    java.util.List<T> values = new ArrayList<>();
    while (!queue.isEmpty()) {
      values.add(queue.dequeue());
    }
    return values.toString();
  }

}

/**
 * Base template for binary-tree exercises.
 *
 * @param <T> value type stored in the tree
 */
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

/**
 * Base template for binary-search-tree exercises.
 *
 * <p>The type parameter is constrained to {@link Comparable} because every BST exercise relies on
 * the ordering invariant to produce deterministic {@code inOrder()} feedback.</p>
 *
 * @param <T> comparable value type stored in the tree
 */
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

/**
 * Base template for AVL-tree exercises.
 *
 * <p>Like the BST family, this template uses comparable values so exercises can teach ordering and
 * balancing through observable operations such as {@code contains}, {@code height}, and
 * {@code inOrder()}.</p>
 *
 * @param <T> comparable value type stored in the tree
 */
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

/**
 * Base template for graph exercises.
 *
 * @param <V> vertex value type used in the graph scenario
 */
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

/**
 * Base template for hash-table exercises.
 *
 * @param <K> key type used by the exercise
 * @param <V> value type stored in the table
 */
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
