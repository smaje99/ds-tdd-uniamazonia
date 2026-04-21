package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.SortingAlgorithm;
import co.edu.udla.ed.contract.AbstractIntegerSortingAlgorithmContractTest;
import co.edu.udla.ed.impl.scratch.sorting.CountingSort;

public class CountingSortTest extends AbstractIntegerSortingAlgorithmContractTest {

  @Override
  protected SortingAlgorithm<Integer> createAlgorithm() {
    return new CountingSort();
  }

}
