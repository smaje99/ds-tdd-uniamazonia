package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.OpenAddressingHashTable;

/**
 * Exercise 03 for the Open-Addressing Hash Table series.
 *
 * <p><strong>Student task:</strong> Remove one key and report the remaining state.</p>
 */
public final class OpenAddressingHashTableExercise03 {

  public String solveWithCustomIterator(OpenAddressingHashTable<String, Integer> table) {
    table.put("A", 10);
    table.put("B", 20);
    table.put("C", 30);
    Integer removed = table.remove("B");
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("containsB", table.containsKey("B")),
        ExerciseSupport.named("size", table.size()));
  }

  public String solveWithJavaLoops(LinkedHashMap<String, Integer> table) {
    table.put("A", 10);
    table.put("B", 20);
    table.put("C", 30);
    Integer removed = table.remove("B");
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("containsB", table.containsKey("B")),
        ExerciseSupport.named("size", table.size()));
  }

  public String solveWithStreams(LinkedHashMap<String, Integer> table) {
    table.put("A", 10);
    table.put("B", 20);
    table.put("C", 30);
    Integer removed = table.remove("B");
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("containsB", table.containsKey("B")),
        ExerciseSupport.named("size", table.entrySet().stream().count()));
  }

}
