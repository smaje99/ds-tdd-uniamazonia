package co.edu.udla.ed.common;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

import co.edu.udla.ed.api.SortingAlgorithm;
import co.edu.udla.ed.impl.scratch.sorting.JavaListSequenceAdapter;

/**
 * Utility methods that reuse repository sorting algorithms with JDK linear
 * collections.
 *
 * <p>Each adapter method copies the input collection, sorts the copy through a
 * {@link JavaListSequenceAdapter}, and returns the sorted copy. The source
 * collection is never mutated.</p>
 */
public final class JavaSortingAdapters {

  private JavaSortingAdapters() {
  }

  /**
   * Returns a sorted copy of an {@link ArrayList} using the algorithm's natural
   * ordering mode.
   *
   * @param values source values to copy
   * @param algorithm sorting algorithm to apply
   * @param <T> element type
   * @return a new sorted {@link ArrayList}
   */
  public static <T> ArrayList<T> sorted(ArrayList<T> values, SortingAlgorithm<T> algorithm) {
    return sorted(values, algorithm, null);
  }

  /**
   * Returns a sorted copy of an {@link ArrayList} using the supplied comparator.
   *
   * @param values source values to copy
   * @param algorithm sorting algorithm to apply
   * @param comparator comparator used by comparison-based algorithms, or
   *        {@code null} to use natural ordering
   * @param <T> element type
   * @return a new sorted {@link ArrayList}
   */
  public static <T> ArrayList<T> sorted(ArrayList<T> values, SortingAlgorithm<T> algorithm,
      Comparator<? super T> comparator) {
    ArrayList<T> copy = new ArrayList<>(values);
    algorithm.sort(new JavaListSequenceAdapter<>(copy), comparator);
    return copy;
  }

  /**
   * Returns a sorted copy of a {@link LinkedList} using the algorithm's natural
   * ordering mode.
   *
   * @param values source values to copy
   * @param algorithm sorting algorithm to apply
   * @param <T> element type
   * @return a new sorted {@link LinkedList}
   */
  public static <T> LinkedList<T> sorted(LinkedList<T> values, SortingAlgorithm<T> algorithm) {
    return sorted(values, algorithm, null);
  }

  /**
   * Returns a sorted copy of a {@link LinkedList} using the supplied comparator.
   *
   * @param values source values to copy
   * @param algorithm sorting algorithm to apply
   * @param comparator comparator used by comparison-based algorithms, or
   *        {@code null} to use natural ordering
   * @param <T> element type
   * @return a new sorted {@link LinkedList}
   */
  public static <T> LinkedList<T> sorted(LinkedList<T> values, SortingAlgorithm<T> algorithm,
      Comparator<? super T> comparator) {
    LinkedList<T> copy = new LinkedList<>(values);
    algorithm.sort(new JavaListSequenceAdapter<>(copy), comparator);
    return copy;
  }

}
