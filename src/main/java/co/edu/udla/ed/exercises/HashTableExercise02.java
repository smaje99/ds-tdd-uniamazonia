package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.HashTable;

/**
 * Guided exercise 02 for the hash-table series.
 *
 * <p>This scenario overwrites an existing key and reports both the previous value and final state. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
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