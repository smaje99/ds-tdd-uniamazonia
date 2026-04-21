package co.edu.udla.ed.impl.scratch.search;

import java.util.Objects;

import co.edu.udla.ed.api.IndexedSequence;
import co.edu.udla.ed.api.LinearSearchResult;

/**
 * Sequential search over any indexed sequence.
 *
 * @param <T> element type
 */
public class LinearSearch<T> {

  public LinearSearchResult<T> search(IndexedSequence<T> sequence, T target) {
    for (int index = 0; index < sequence.size(); index++) {
      T value = sequence.get(index);
      if (Objects.equals(value, target)) {
        return LinearSearchResult.found(index, value);
      }
    }
    return LinearSearchResult.notFound();
  }

}
