package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.HashTable;

/**
 * Guided exercise 01 for the hash-table series.
 *
 * <p>This scenario introduces insertion, lookup, and size reporting in the table. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
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