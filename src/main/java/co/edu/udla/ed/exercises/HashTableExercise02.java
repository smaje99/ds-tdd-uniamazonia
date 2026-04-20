package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.SeparateChainingHashTable;

/**
 * Exercise 02 for the Hash Table series.
 *
 * <p><strong>Student task:</strong> Update an existing key and report the previous value, the current size, and the updated lookup.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class HashTableExercise02 {

  /**
   * Solves Exercise 02 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(SeparateChainingHashTable<String, Integer> table) {
    table.put("A", 10);
    Integer previous = table.put("A", 99);
    return ExerciseSupport.format(
        ExerciseSupport.named("previous", previous),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(table)),
        ExerciseSupport.named("getA", table.get("A")));
  }

  /**
   * Solves Exercise 02 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(LinkedHashMap<String, Integer> table) {
    table.put("A", 10);
    Integer previous = table.put("A", 99);
    return ExerciseSupport.format(
        ExerciseSupport.named("previous", previous),
        ExerciseSupport.named("size", table.size()),
        ExerciseSupport.named("getA", table.get("A")));
  }

  /**
   * Solves Exercise 02 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(LinkedHashMap<String, Integer> table) {
    table.put("A", 10);
    Integer previous = table.put("A", 99);
    return ExerciseSupport.format(
        ExerciseSupport.named("previous", previous),
        ExerciseSupport.named("size", table.entrySet().stream().count()),
        ExerciseSupport.named("getA", table.get("A")));
  }

}
