package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.IndexedSequence;
import co.edu.udla.ed.api.LinearSearchResult;
import co.edu.udla.ed.contract.AbstractLinearSearchContractTest;
import co.edu.udla.ed.impl.scratch.search.LinearSearch;

public class LinearSearchTest extends AbstractLinearSearchContractTest {

  @Override
  protected LinearSearchResult<String> search(IndexedSequence<String> values, String target) {
    return new LinearSearch<String>().search(values, target);
  }

}
