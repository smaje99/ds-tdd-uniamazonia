package co.edu.udla.ed.impl.scratch.sorting;

import java.util.Comparator;

import co.edu.udla.ed.api.MutableIndexedSequence;
import co.edu.udla.ed.api.SortingAlgorithm;

/**
 * In-place Shell sort over a mutable indexed sequence.
 *
 * <p>
 * Shell sort generalizes insertion sort by first comparing values separated by
 * a gap. This implementation uses the simple halving gap sequence, then finishes
 * with a normal gap of one. It is useful for showing how reducing long-distance
 * disorder can improve practical performance over plain insertion sort.
 * </p>
 *
 * <p>
 * Complexity depends on the gap sequence; this implementation is commonly
 * subquadratic on practical inputs but still has a quadratic worst-case bound
 * for teaching purposes. Extra space is {@code O(1)} and the algorithm is not
 * stable. When no comparator is provided, elements must implement
 * {@link Comparable}.
 * </p>
 *
 * @param <T> element type
 */
public class ShellSort<T> implements SortingAlgorithm<T> {

  /** {@inheritDoc} */
  @Override
  public void sort(MutableIndexedSequence<T> sequence, Comparator<? super T> comparator) {
    Comparator<? super T> actual = SortingSupport.comparatorOrNatural(comparator);
    for (int gap = sequence.size() / 2; gap > 0; gap /= 2) {
      for (int index = gap; index < sequence.size(); index++) {
        T current = sequence.get(index);
        int position = index;
        while (position >= gap && actual.compare(sequence.get(position - gap), current) > 0) {
          sequence.set(position, sequence.get(position - gap));
          position -= gap;
        }
        sequence.set(position, current);
      }
    }
  }

}
