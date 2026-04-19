package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.HashTable;

public final class HashTableExercise01 extends AbstractStringHashTableExercise {

  @Override
  protected String solve(HashTable<String, Integer> table) {
    table.put("A", 10);
    table.put("B", 20);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", table.size()),
        ExerciseSupport.named("getA", table.get("A")),
        ExerciseSupport.named("getB", table.get("B")));
  }

}