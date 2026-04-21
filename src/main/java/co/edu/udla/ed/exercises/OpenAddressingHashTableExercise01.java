package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.OpenAddressingHashTable;

/**
 * Exercise 01 for the Open-Addressing Hash Table series.
 *
 * <p><strong>Student task:</strong> Insert basic key-value pairs and report size together with direct lookups.</p>
 */
public final class OpenAddressingHashTableExercise01 {

  public String solveWithCustomIterator(OpenAddressingHashTable<String, Integer> table) {
    table.put("A", 10);
    table.put("B", 20);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(table)),
        ExerciseSupport.named("getA", table.get("A")),
        ExerciseSupport.named("getB", table.get("B")));
  }

  public String solveWithJavaLoops(LinkedHashMap<String, Integer> table) {
    table.put("A", 10);
    table.put("B", 20);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", table.size()),
        ExerciseSupport.named("getA", table.get("A")),
        ExerciseSupport.named("getB", table.get("B")));
  }

  public String solveWithStreams(LinkedHashMap<String, Integer> table) {
    table.put("A", 10);
    table.put("B", 20);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", table.entrySet().stream().count()),
        ExerciseSupport.named("getA", table.get("A")),
        ExerciseSupport.named("getB", table.get("B")));
  }

}
