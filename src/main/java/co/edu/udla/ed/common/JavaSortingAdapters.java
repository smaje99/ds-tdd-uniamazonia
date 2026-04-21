package co.edu.udla.ed.common;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

import co.edu.udla.ed.api.SortingAlgorithm;
import co.edu.udla.ed.impl.scratch.sorting.JavaListSequenceAdapter;

/**
 * Utility methods that reuse the repository sorting algorithms with JDK linear collections.
 */
public final class JavaSortingAdapters {

  private JavaSortingAdapters() {
  }

  public static <T> ArrayList<T> sorted(ArrayList<T> values, SortingAlgorithm<T> algorithm) {
    return sorted(values, algorithm, null);
  }

  public static <T> ArrayList<T> sorted(ArrayList<T> values, SortingAlgorithm<T> algorithm,
      Comparator<? super T> comparator) {
    ArrayList<T> copy = new ArrayList<>(values);
    algorithm.sort(new JavaListSequenceAdapter<>(copy), comparator);
    return copy;
  }

  public static <T> LinkedList<T> sorted(LinkedList<T> values, SortingAlgorithm<T> algorithm) {
    return sorted(values, algorithm, null);
  }

  public static <T> LinkedList<T> sorted(LinkedList<T> values, SortingAlgorithm<T> algorithm,
      Comparator<? super T> comparator) {
    LinkedList<T> copy = new LinkedList<>(values);
    algorithm.sort(new JavaListSequenceAdapter<>(copy), comparator);
    return copy;
  }

}
