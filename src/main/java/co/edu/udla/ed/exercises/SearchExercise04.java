package co.edu.udla.ed.exercises;

import java.util.TreeSet;

import co.edu.udla.ed.api.TreeSearchResult;
import co.edu.udla.ed.common.JavaSearchAdapters;
import co.edu.udla.ed.impl.scratch.LinkedBinarySearchTree;
import co.edu.udla.ed.impl.scratch.search.OrderedTreeSearch;

/**
 * Exercise 04 for the Search series.
 *
 * <p><strong>Student task:</strong> Search an ordered tree and report both the match and the
 * observable visited values.</p>
 */
public final class SearchExercise04 {

  public String solveWithCustomIterator(LinkedBinarySearchTree<Integer> tree) {
    tree.insert(8);
    tree.insert(3);
    tree.insert(10);
    tree.insert(1);
    tree.insert(6);
    TreeSearchResult<Integer> result = new OrderedTreeSearch<Integer>().search(tree, 6);
    return format(result);
  }

  public String solveWithJavaLoops(TreeSet<Integer> tree) {
    tree.add(8);
    tree.add(3);
    tree.add(10);
    tree.add(1);
    tree.add(6);
    TreeSearchResult<Integer> result = JavaSearchAdapters.orderedTreeSearch(tree, 6);
    return format(result);
  }

  public String solveWithStreams(TreeSet<Integer> tree) {
    tree.add(8);
    tree.add(3);
    tree.add(10);
    tree.add(1);
    tree.add(6);
    TreeSearchResult<Integer> result = JavaSearchAdapters.orderedTreeSearch(tree, 6);
    return format(result);
  }

  private String format(TreeSearchResult<Integer> result) {
    return ExerciseSupport.format(
        ExerciseSupport.named("found", result.found()),
        ExerciseSupport.named("target", result.target()),
        ExerciseSupport.named("visited", result.visited()));
  }

}
