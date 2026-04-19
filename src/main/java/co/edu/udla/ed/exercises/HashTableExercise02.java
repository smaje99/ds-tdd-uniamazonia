package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.HashTable;

public final class HashTableExercise02 extends AbstractStringHashTableExercise {

  @Override
  protected String solve(HashTable<String, Integer> table) {
    table.put("A", 10);
    Integer previous = table.put("A", 99);
    return ExerciseSupport.format(
        ExerciseSupport.named("previous", previous),
        ExerciseSupport.named("size", table.size()),
        ExerciseSupport.named("getA", table.get("A")));
  }

}