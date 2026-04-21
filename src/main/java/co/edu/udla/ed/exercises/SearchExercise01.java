package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.api.LinearSearchResult;
import co.edu.udla.ed.common.JavaSearchAdapters;
import co.edu.udla.ed.impl.scratch.StaticSimpleList;
import co.edu.udla.ed.impl.scratch.search.LinearSearch;
import co.edu.udla.ed.impl.scratch.sorting.ScratchListSequenceAdapter;

/**
 * Exercise 01 for the Search series.
 *
 * <p><strong>Student task:</strong> Search an unordered linear sequence and report the first
 * matching index.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration or public adapters to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class SearchExercise01 {

  public String solveWithCustomIterator(StaticSimpleList<String> list) {
    list.addLast("rojo");
    list.addLast("azul");
    list.addLast("verde");
    list.addLast("azul");
    LinearSearchResult<String> result = new LinearSearch<String>()
        .search(new ScratchListSequenceAdapter<>(list), "azul");
    return format(result);
  }

  public String solveWithJavaLoops(ArrayList<String> list) {
    list.add("rojo");
    list.add("azul");
    list.add("verde");
    list.add("azul");
    LinearSearchResult<String> result = JavaSearchAdapters.linearSearch(list, "azul");
    return format(result);
  }

  public String solveWithStreams(ArrayList<String> list) {
    list.add("rojo");
    list.add("azul");
    list.add("verde");
    list.add("azul");
    LinearSearchResult<String> result = JavaSearchAdapters.linearSearch(list, "azul");
    return format(result);
  }

  private String format(LinearSearchResult<String> result) {
    return ExerciseSupport.format(
        ExerciseSupport.named("found", result.found()),
        ExerciseSupport.named("index", result.index()),
        ExerciseSupport.named("value", result.value()));
  }

}
