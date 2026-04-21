package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.SortingAlgorithm;
import co.edu.udla.ed.contract.AbstractSortingAlgorithmContractTest;
import co.edu.udla.ed.impl.scratch.sorting.ShellSort;

public class ShellSortTest extends AbstractSortingAlgorithmContractTest {

  @Override
  protected SortingAlgorithm<Integer> createAlgorithm() {
    return new ShellSort<>();
  }

}
