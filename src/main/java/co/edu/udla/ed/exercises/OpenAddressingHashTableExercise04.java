package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.exercises.ExerciseSupport.BadHashKey;
import co.edu.udla.ed.impl.scratch.OpenAddressingHashTable;

/**
 * Exercise 04 for the Open-Addressing Hash Table series.
 *
 * <p><strong>Student task:</strong> Insert collision-heavy domain keys and verify that all associated values remain
 * reachable.</p>
 */
public final class OpenAddressingHashTableExercise04 {

  public String solveWithCustomIterator(OpenAddressingHashTable<BadHashKey, Integer> table) {
    BadHashKey a = new BadHashKey("A");
    BadHashKey b = new BadHashKey("B");
    BadHashKey c = new BadHashKey("C");
    table.put(a, 10);
    table.put(b, 20);
    table.put(c, 30);
    return ExerciseSupport.format(
        ExerciseSupport.named("A", table.get(a)),
        ExerciseSupport.named("B", table.get(b)),
        ExerciseSupport.named("C", table.get(c)));
  }

  public String solveWithJavaLoops(LinkedHashMap<BadHashKey, Integer> table) {
    BadHashKey a = new BadHashKey("A");
    BadHashKey b = new BadHashKey("B");
    BadHashKey c = new BadHashKey("C");
    table.put(a, 10);
    table.put(b, 20);
    table.put(c, 30);
    return ExerciseSupport.format(
        ExerciseSupport.named("A", table.get(a)),
        ExerciseSupport.named("B", table.get(b)),
        ExerciseSupport.named("C", table.get(c)));
  }

  public String solveWithStreams(LinkedHashMap<BadHashKey, Integer> table) {
    BadHashKey a = new BadHashKey("A");
    BadHashKey b = new BadHashKey("B");
    BadHashKey c = new BadHashKey("C");
    table.put(a, 10);
    table.put(b, 20);
    table.put(c, 30);
    return ExerciseSupport.format(
        ExerciseSupport.named("A", table.get(a)),
        ExerciseSupport.named("B", table.get(b)),
        ExerciseSupport.named("C", table.get(c)));
  }

}
