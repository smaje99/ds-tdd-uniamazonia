package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.api.LinearSearchResult;
import co.edu.udla.ed.common.JavaSearchAdapters;
import co.edu.udla.ed.impl.scratch.StaticSimpleList;
import co.edu.udla.ed.impl.scratch.search.BinarySearch;
import co.edu.udla.ed.impl.scratch.sorting.ScratchListSequenceAdapter;

/**
 * Exercise 02 for the Search series.
 *
 * <p><strong>Student task:</strong> Search an ordered linear sequence with binary search and
 * report the located index.</p>
 */
public final class SearchExercise02 {

  public String solveWithCustomIterator(StaticSimpleList<Integer> list) {
    list.addLast(2);
    list.addLast(4);
    list.addLast(6);
    list.addLast(8);
    list.addLast(10);
    LinearSearchResult<Integer> result = new BinarySearch<Integer>()
        .search(new ScratchListSequenceAdapter<>(list), 8);
    return format(result);
  }

  public String solveWithJavaLoops(ArrayList<Integer> list) {
    list.add(2);
    list.add(4);
    list.add(6);
    list.add(8);
    list.add(10);
    LinearSearchResult<Integer> result = JavaSearchAdapters.binarySearch(list, 8, null);
    return format(result);
  }

  public String solveWithStreams(ArrayList<Integer> list) {
    list.add(2);
    list.add(4);
    list.add(6);
    list.add(8);
    list.add(10);
    LinearSearchResult<Integer> result = JavaSearchAdapters.binarySearch(list, 8, null);
    return format(result);
  }

  private String format(LinearSearchResult<Integer> result) {
    return ExerciseSupport.format(
        ExerciseSupport.named("found", result.found()),
        ExerciseSupport.named("index", result.index()),
        ExerciseSupport.named("value", result.value()));
  }

}
