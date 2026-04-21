package co.edu.udla.ed.impl.scratch.sorting;

import java.util.Comparator;

import co.edu.udla.ed.api.MutableIndexedSequence;
import co.edu.udla.ed.api.SortingAlgorithm;

public class RadixSort implements SortingAlgorithm<Integer> {

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
