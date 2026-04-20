package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.SeparateChainingHashTable;

public final class HashTableExercise02 {

  public String solveWithCustomIterator(SeparateChainingHashTable<String, Integer> table) {
    table.put("A", 10);
    Integer previous = table.put("A", 99);
    return ExerciseSupport.format(
        ExerciseSupport.named("previous", previous),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(table)),
        ExerciseSupport.named("getA", table.get("A")));
  }

  public String solveWithJavaLoops(LinkedHashMap<String, Integer> table) {
    table.put("A", 10);
    Integer previous = table.put("A", 99);
    return ExerciseSupport.format(
        ExerciseSupport.named("previous", previous),
        ExerciseSupport.named("size", table.size()),
        ExerciseSupport.named("getA", table.get("A")));
  }

  public String solveWithStreams(LinkedHashMap<String, Integer> table) {
    table.put("A", 10);
    Integer previous = table.put("A", 99);
    return ExerciseSupport.format(
        ExerciseSupport.named("previous", previous),
        ExerciseSupport.named("size", table.entrySet().stream().count()),
        ExerciseSupport.named("getA", table.get("A")));
  }

}
