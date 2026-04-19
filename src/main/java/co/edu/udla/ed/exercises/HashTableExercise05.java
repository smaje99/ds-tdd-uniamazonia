package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.HashTable;

/**
 * Guided exercise 05 for the hash-table series.
 *
 * <p>This scenario uses domain keys and values so updates and removals can be studied with custom equality and hash codes. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class HashTableExercise05 extends AbstractDomainHashTableExercise {

  @Override
  protected String solve(HashTable<ExerciseSupport.EnrollmentKey, ExerciseSupport.Learner> table) {
    table.put(key("EDA", "A1"), ExerciseSupport.learner("Ana", 101));
    table.put(key("MAT", "B2"), ExerciseSupport.learner("Luis", 203));
    table.put(key("FIS", "C3"), ExerciseSupport.learner("Mia", 305));

    ExerciseSupport.Learner previous = table.put(key("MAT", "B2"), ExerciseSupport.learner("Eva", 99));
    ExerciseSupport.Learner removed = table.remove(key("FIS", "C3"));

    return ExerciseSupport.format(
        ExerciseSupport.named("previous", previous),
        ExerciseSupport.named("size", table.size()),
        ExerciseSupport.named("getMAT", table.get(key("MAT", "B2"))),
        ExerciseSupport.named("removedFIS", removed),
        ExerciseSupport.named("containsEDA", table.containsKey(key("EDA", "A1"))));
  }

}
