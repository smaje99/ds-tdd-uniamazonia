package co.edu.udla.ed.exercises;

import java.util.ArrayList;
import co.edu.udla.ed.api.HashTable;

public final class HashTableExercise04 extends AbstractCollisionHashTableExercise {

  @Override
  protected String solve(HashTable<ExerciseSupport.BadHashKey, Integer> table) {
    ArrayList<ExerciseSupport.BadHashKey> keys = new ArrayList<>();
    for (int i = 0; i <= 17; i++) {
      ExerciseSupport.BadHashKey key = key("K" + i);
      keys.add(key);
      table.put(key, i);
    }

    Integer removed = table.remove(keys.get(7));

    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("size", table.size()),
        ExerciseSupport.named("getK0", table.get(keys.get(0))),
        ExerciseSupport.named("getK17", table.get(keys.get(17))),
        ExerciseSupport.named("containsK7", table.containsKey(keys.get(7))));
  }

}