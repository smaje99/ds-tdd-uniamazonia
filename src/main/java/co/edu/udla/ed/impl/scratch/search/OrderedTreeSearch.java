package co.edu.udla.ed.impl.scratch.search;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import co.edu.udla.ed.api.AVLTree;
import co.edu.udla.ed.api.BTree;
import co.edu.udla.ed.api.BinarySearchTree;
import co.edu.udla.ed.api.RedBlackTree;
import co.edu.udla.ed.api.TreeSearchResult;

/**
 * Observable search over ordered tree abstractions.
 *
 * @param <T> comparable element type
 */
public class OrderedTreeSearch<T extends Comparable<T>> {

  /**
   * Searches a binary search tree by scanning its ordered traversal.
   *
   * @param tree tree to search
   * @param target value to locate
   * @return found flag and sorted values visited until the search can stop
   */
  public TreeSearchResult<T> search(BinarySearchTree<T> tree, T target) {
    return searchOrdered(tree.inOrder(), target);
  }

  /**
   * Searches an AVL tree by scanning its ordered traversal.
   *
   * @param tree tree to search
   * @param target value to locate
   * @return found flag and sorted values visited until the search can stop
   */
  public TreeSearchResult<T> search(AVLTree<T> tree, T target) {
    return searchOrdered(tree.inOrder(), target);
  }

  /**
   * Searches a red-black tree by scanning its ordered traversal.
   *
   * @param tree tree to search
   * @param target value to locate
   * @return found flag and sorted values visited until the search can stop
   */
  public TreeSearchResult<T> search(RedBlackTree<T> tree, T target) {
    return searchOrdered(tree.inOrder(), target);
  }

  /**
   * Searches a B-tree by scanning its ordered traversal.
   *
   * @param tree tree to search
   * @param target value to locate
   * @return found flag and sorted values visited until the search can stop
   */
  public TreeSearchResult<T> search(BTree<T> tree, T target) {
    return searchOrdered(tree.inOrder(), target);
  }

  /**
   * Searches a JDK ordered set by scanning values in ascending order.
   *
   * @param tree set to search
   * @param target value to locate
   * @return found flag and sorted values visited until the search can stop
   */
  public TreeSearchResult<T> search(TreeSet<T> tree, T target) {
    return searchOrdered(new ArrayList<>(tree), target);
  }

  private TreeSearchResult<T> searchOrdered(List<T> orderedValues, T target) {
    List<T> visited = new ArrayList<>();
    boolean found = false;
    for (T value : orderedValues) {
      visited.add(value);
      int comparison = value.compareTo(target);
      if (comparison == 0) {
        found = true;
        break;
      }
      if (comparison > 0) {
        break;
      }
    }
    return new TreeSearchResult<>(found, target, visited);
  }

}
