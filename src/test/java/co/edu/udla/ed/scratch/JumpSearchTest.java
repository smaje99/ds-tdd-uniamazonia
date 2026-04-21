package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.IndexedSequence;
import co.edu.udla.ed.api.LinearSearchResult;
import co.edu.udla.ed.contract.AbstractSortedIndexedSearchContractTest;
import co.edu.udla.ed.impl.scratch.search.JumpSearch;

public class JumpSearchTest extends AbstractSortedIndexedSearchContractTest {

  @Override
  protected LinearSearchResult<Integer> search(IndexedSequence<Integer> values, Integer target) {
    return new JumpSearch<Integer>().search(values, target);
  }

}
