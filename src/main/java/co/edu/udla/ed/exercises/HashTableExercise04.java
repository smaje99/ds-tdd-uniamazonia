package co.edu.udla.ed.exercises;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.SeparateChainingHashTable;

/**
 * Exercise 04 for the Hash Table series.
 *
 * <p><strong>Student task:</strong> Force many collision-prone keys, remove one of them, and validate size and selected lookups after the updates.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class HashTableExercise04 {

  /**
   * Solves Exercise 04 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
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

  /**
   * Solves Exercise 04 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
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

  /**
   * Solves Exercise 04 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
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
