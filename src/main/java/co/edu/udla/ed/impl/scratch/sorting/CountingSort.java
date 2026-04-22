package co.edu.udla.ed.impl.scratch.sorting;

import java.util.Comparator;

import co.edu.udla.ed.api.MutableIndexedSequence;
import co.edu.udla.ed.api.SortingAlgorithm;

/**
 * Stable counting sort for non-negative integer sequences.
 *
 * <p>
 * Counting sort does not compare elements. Instead, it counts how many times
 * each integer value appears and writes the values back in ascending order. This
 * makes it efficient when the maximum value {@code k} is reasonably close to
 * the number of elements.
 * </p>
 *
 * <p>
 * Time complexity is {@code O(n + k)} and extra space is {@code O(k)}. The
 * implementation rejects negative values with {@link IllegalArgumentException}
 * and rejects custom comparators because the algorithm only supports natural
 * ascending integer order.
 * </p>
 */
public class CountingSort implements SortingAlgorithm<Integer> {

  /** {@inheritDoc} */
  @Override
  public void sort(MutableIndexedSequence<Integer> sequence, Comparator<? super Integer> comparator) {
    if (comparator != null) {
      throw new UnsupportedOperationException("Counting sort only supports natural ascending order.");
    }
    if (sequence.size() < 2) {
      return;
    }

    int max = 0;
    for (int index = 0; index < sequence.size(); index++) {
      int value = sequence.get(index);
      if (value < 0) {
        throw new IllegalArgumentException("Counting sort only supports non-negative integers.");
      }
      if (value > max) {
        max = value;
      }
    }

    int[] counts = new int[max + 1];
    for (int index = 0; index < sequence.size(); index++) {
      counts[sequence.get(index)]++;
    }

    int writeIndex = 0;
    for (int value = 0; value < counts.length; value++) {
      for (int count = 0; count < counts[value]; count++) {
        sequence.set(writeIndex++, value);
      }
    }
  }

}
