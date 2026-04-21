package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.OpenAddressingHashTable;

/**
 * Exercise 05 for the Open-Addressing Hash Table series.
 *
 * <p><strong>Student task:</strong> Clear the table, insert fresh data, and inspect the rebuilt state.</p>
 */
public final class OpenAddressingHashTableExercise05 {

  public String solveWithCustomIterator(OpenAddressingHashTable<String, Integer> table) {
    table.put("A", 10);
    table.put("B", 20);
    table.clear();
    table.put("C", 30);
    table.put("D", 40);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", table.size()),
        ExerciseSupport.named("getC", table.get("C")),
        ExerciseSupport.named("getD", table.get("D")));
  }

  public String solveWithJavaLoops(LinkedHashMap<String, Integer> table) {
    table.put("A", 10);
    table.put("B", 20);
    table.clear();
    table.put("C", 30);
    table.put("D", 40);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", table.size()),
        ExerciseSupport.named("getC", table.get("C")),
        ExerciseSupport.named("getD", table.get("D")));
  }

  public String solveWithStreams(LinkedHashMap<String, Integer> table) {
    table.put("A", 10);
    table.put("B", 20);
    table.clear();
    table.put("C", 30);
    table.put("D", 40);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", table.entrySet().stream().count()),
        ExerciseSupport.named("getC", table.get("C")),
        ExerciseSupport.named("getD", table.get("D")));
  }

}
