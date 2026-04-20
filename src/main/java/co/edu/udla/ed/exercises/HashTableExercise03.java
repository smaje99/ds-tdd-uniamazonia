package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.SeparateChainingHashTable;

/**
 * Exercise 03 for the Hash Table series.
 *
 * <p><strong>Student task:</strong> Remove one key, inspect containment and size, then clear the table and report the empty state.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class HashTableExercise03 {

  /**
   * Solves Exercise 03 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
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

  /**
   * Solves Exercise 03 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
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

  /**
   * Solves Exercise 03 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
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
