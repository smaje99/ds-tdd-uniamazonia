package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.SeparateChainingHashTable;

public final class HashTableExercise03 {

  public String solveWithCustomIterator(SeparateChainingHashTable<String, Integer> table) {
    table.put("A", 10);
    table.put("B", 20);
    Integer removed = table.remove("A");
    int sizeBeforeClear = ExerciseSupport.countWithIterator(table);
    table.clear();
    return ExerciseSupport.format(
        ExerciseSupport.named("removedA", removed),
        ExerciseSupport.named("containsA", table.containsKey("A")),
        ExerciseSupport.named("sizeBeforeClear", sizeBeforeClear),
        ExerciseSupport.named("emptyAfterClear", table.isEmpty()));
  }

  public String solveWithJavaLoops(LinkedHashMap<String, Integer> table) {
    table.put("A", 10);
    table.put("B", 20);
    Integer removed = table.remove("A");
    int sizeBeforeClear = table.size();
    table.clear();
    return ExerciseSupport.format(
        ExerciseSupport.named("removedA", removed),
        ExerciseSupport.named("containsA", table.containsKey("A")),
        ExerciseSupport.named("sizeBeforeClear", sizeBeforeClear),
        ExerciseSupport.named("emptyAfterClear", table.isEmpty()));
  }

  public String solveWithStreams(LinkedHashMap<String, Integer> table) {
    table.put("A", 10);
    table.put("B", 20);
    Integer removed = table.remove("A");
    long sizeBeforeClear = table.entrySet().stream().count();
    table.clear();
    return ExerciseSupport.format(
        ExerciseSupport.named("removedA", removed),
        ExerciseSupport.named("containsA", table.containsKey("A")),
        ExerciseSupport.named("sizeBeforeClear", sizeBeforeClear),
        ExerciseSupport.named("emptyAfterClear", table.isEmpty()));
  }

}
