package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.HashTable;

/**
 * Guided exercise 03 for the hash-table series.
 *
 * <p>This scenario removes a key, checks membership, and then clears the table. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
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