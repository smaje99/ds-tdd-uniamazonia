package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.api.KeyValueSearchResult;
import co.edu.udla.ed.common.JavaSearchAdapters;
import co.edu.udla.ed.impl.scratch.SeparateChainingHashTable;
import co.edu.udla.ed.impl.scratch.search.HashTableKeySearch;

/**
 * Exercise 03 for the Search series.
 *
 * <p><strong>Student task:</strong> Search a key in a key-value structure and report the
 * associated value.</p>
 */
public final class SearchExercise03 {

  public String solveWithCustomIterator(SeparateChainingHashTable<String, Integer> table) {
    table.put("Ana", 90);
    table.put("Luis", 85);
    KeyValueSearchResult<String, Integer> result = new HashTableKeySearch<String, Integer>().search(table, "Luis");
    return format(result);
  }

  public String solveWithJavaLoops(LinkedHashMap<String, Integer> table) {
    table.put("Ana", 90);
    table.put("Luis", 85);
    KeyValueSearchResult<String, Integer> result = JavaSearchAdapters.keyValueSearch(table, "Luis");
    return format(result);
  }

  public String solveWithStreams(LinkedHashMap<String, Integer> table) {
    table.put("Ana", 90);
    table.put("Luis", 85);
    KeyValueSearchResult<String, Integer> result = JavaSearchAdapters.keyValueSearch(table, "Luis");
    return format(result);
  }

  private String format(KeyValueSearchResult<String, Integer> result) {
    return ExerciseSupport.format(
        ExerciseSupport.named("found", result.found()),
        ExerciseSupport.named("key", result.key()),
        ExerciseSupport.named("value", result.value()));
  }

}
