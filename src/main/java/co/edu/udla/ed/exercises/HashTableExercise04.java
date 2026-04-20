package co.edu.udla.ed.exercises;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.SeparateChainingHashTable;

public final class HashTableExercise04 {

  public String solveWithCustomIterator(SeparateChainingHashTable<ExerciseSupport.BadHashKey, Integer> table) {
    ArrayList<ExerciseSupport.BadHashKey> keys = new ArrayList<>();
    for (int i = 0; i <= 17; i++) {
      ExerciseSupport.BadHashKey key = new ExerciseSupport.BadHashKey("K" + i);
      keys.add(key);
      table.put(key, i);
    }
    Integer removed = table.remove(keys.get(7));
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(table)),
        ExerciseSupport.named("getK0", table.get(keys.get(0))),
        ExerciseSupport.named("getK17", table.get(keys.get(17))),
        ExerciseSupport.named("containsK7", table.containsKey(keys.get(7))));
  }

  public String solveWithJavaLoops(LinkedHashMap<ExerciseSupport.BadHashKey, Integer> table) {
    ArrayList<ExerciseSupport.BadHashKey> keys = new ArrayList<>();
    for (int i = 0; i <= 17; i++) {
      ExerciseSupport.BadHashKey key = new ExerciseSupport.BadHashKey("K" + i);
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

  public String solveWithStreams(LinkedHashMap<ExerciseSupport.BadHashKey, Integer> table) {
    ArrayList<ExerciseSupport.BadHashKey> keys = new ArrayList<>();
    for (int i = 0; i <= 17; i++) {
      ExerciseSupport.BadHashKey key = new ExerciseSupport.BadHashKey("K" + i);
      keys.add(key);
      table.put(key, i);
    }
    Integer removed = table.remove(keys.get(7));
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("size", table.entrySet().stream().count()),
        ExerciseSupport.named("getK0", table.get(keys.get(0))),
        ExerciseSupport.named("getK17", table.get(keys.get(17))),
        ExerciseSupport.named("containsK7", table.containsKey(keys.get(7))));
  }

}
