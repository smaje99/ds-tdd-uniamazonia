package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.SeparateChainingHashTable;

/**
 * Exercise 01 for the Hash Table series.
 *
 * <p><strong>Student task:</strong> Insert key-value pairs and report size together with direct lookups.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class HashTableExercise01 {

  /**
   * Solves Exercise 01 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(SeparateChainingHashTable<String, Integer> table) {
    table.put("A", 10);
    table.put("B", 20);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(table)),
        ExerciseSupport.named("getA", table.get("A")),
        ExerciseSupport.named("getB", table.get("B")));
  }

  /**
   * Solves Exercise 01 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(LinkedHashMap<String, Integer> table) {
    table.put("A", 10);
    table.put("B", 20);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", table.size()),
        ExerciseSupport.named("getA", table.get("A")),
        ExerciseSupport.named("getB", table.get("B")));
  }

  /**
   * Solves Exercise 01 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(LinkedHashMap<String, Integer> table) {
    table.put("A", 10);
    table.put("B", 20);
    return ExerciseSupport.format(
        ExerciseSupport.named("size", table.entrySet().stream().count()),
        ExerciseSupport.named("getA", table.get("A")),
        ExerciseSupport.named("getB", table.get("B")));
  }

}
