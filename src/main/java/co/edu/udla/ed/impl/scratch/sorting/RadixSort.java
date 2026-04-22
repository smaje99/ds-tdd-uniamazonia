package co.edu.udla.ed.impl.scratch.sorting;

import java.util.Comparator;

import co.edu.udla.ed.api.MutableIndexedSequence;
import co.edu.udla.ed.api.SortingAlgorithm;

/**
 * Stable least-significant-digit radix sort for non-negative integers.
 *
 * <p>
 * The algorithm processes decimal digits from right to left and uses a stable
 * counting pass for each digit. It is useful for teaching non-comparison-based
 * sorting when the input domain is numeric and bounded by the number of digits.
 * </p>
 *
 * <p>
 * Time complexity is {@code O(d(n + k))}, where {@code d} is the number of
 * digits and {@code k} is the radix size. This implementation uses base 10,
 * rejects negative values, and rejects custom comparators because digit order is
 * fixed to natural ascending integer order.
 * </p>
 */
public class RadixSort implements SortingAlgorithm<Integer> {

  /** {@inheritDoc} */
  @Override
  public void sort(MutableIndexedSequence<Integer> sequence, Comparator<? super Integer> comparator) {
    if (comparator != null) {
      throw new UnsupportedOperationException("Radix sort only supports natural ascending order.");
    }
    if (sequence.size() < 2) {
      return;
    }

    int max = 0;
    for (int index = 0; index < sequence.size(); index++) {
      int value = sequence.get(index);
      if (value < 0) {
        throw new IllegalArgumentException("Radix sort only supports non-negative integers.");
      }
      if (value > max) {
        max = value;
      }
    }

    Object[] buffer = new Object[sequence.size()];
    for (int exponent = 1; max / exponent > 0; exponent *= 10) {
      int[] counts = new int[10];
      for (int index = 0; index < sequence.size(); index++) {
        counts[(sequence.get(index) / exponent) % 10]++;
      }
      for (int digit = 1; digit < counts.length; digit++) {
        counts[digit] += counts[digit - 1];
      }
      for (int index = sequence.size() - 1; index >= 0; index--) {
        int value = sequence.get(index);
        int digit = (value / exponent) % 10;
        buffer[--counts[digit]] = value;
      }
      for (int index = 0; index < sequence.size(); index++) {
        sequence.set(index, (Integer) buffer[index]);
      }
    }
  }

}
