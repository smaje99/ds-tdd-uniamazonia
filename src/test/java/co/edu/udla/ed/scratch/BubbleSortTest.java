package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.SortingAlgorithm;
import co.edu.udla.ed.contract.AbstractSortingAlgorithmContractTest;
import co.edu.udla.ed.impl.scratch.sorting.BubbleSort;

public class BubbleSortTest extends AbstractSortingAlgorithmContractTest {

  @Override
  protected SortingAlgorithm<Integer> createAlgorithm() {
    return new BubbleSort<>();
  }

}
