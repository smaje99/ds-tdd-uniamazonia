package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.SeparateChainingHashTable;

public final class HashTableExercise01 {

  public String solveWithCustomIterator(SeparateChainingHashTable<String, Integer> table) {
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
