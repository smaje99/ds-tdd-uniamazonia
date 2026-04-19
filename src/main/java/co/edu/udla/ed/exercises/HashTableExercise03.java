package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.HashTable;

public final class HashTableExercise03 extends AbstractStringHashTableExercise {

  @Override
  protected String solve(HashTable<String, Integer> table) {
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

}