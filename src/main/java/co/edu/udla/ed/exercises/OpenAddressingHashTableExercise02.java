package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.OpenAddressingHashTable;

/**
 * Exercise 02 for the Open-Addressing Hash Table series.
 *
 * <p><strong>Student task:</strong> Overwrite the value of an existing key and verify that the table size does not
 * grow.</p>
 */
public final class OpenAddressingHashTableExercise02 {

  public String solveWithCustomIterator(OpenAddressingHashTable<String, Integer> table) {
    table.put("A", 10);
    Integer previous = table.put("A", 99);
    return ExerciseSupport.format(
        ExerciseSupport.named("previous", previous),
        ExerciseSupport.named("size", table.size()),
        ExerciseSupport.named("current", table.get("A")));
  }

  public String solveWithJavaLoops(LinkedHashMap<String, Integer> table) {
    table.put("A", 10);
    Integer previous = table.put("A", 99);
    return ExerciseSupport.format(
        ExerciseSupport.named("previous", previous),
        ExerciseSupport.named("size", table.size()),
        ExerciseSupport.named("current", table.get("A")));
  }

  public String solveWithStreams(LinkedHashMap<String, Integer> table) {
    table.put("A", 10);
    Integer previous = table.put("A", 99);
    return ExerciseSupport.format(
        ExerciseSupport.named("previous", previous),
        ExerciseSupport.named("size", table.entrySet().stream().count()),
        ExerciseSupport.named("current", table.get("A")));
  }

}
