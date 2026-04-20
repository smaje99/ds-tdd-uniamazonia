package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.SeparateChainingHashTable;

/**
 * Exercise 05 for the Hash Table series.
 *
 * <p><strong>Student task:</strong> Use domain keys and values to validate replacement, removal, size, and membership semantics.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class HashTableExercise05 {

  /**
   * Solves Exercise 05 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(
      SeparateChainingHashTable<ExerciseSupport.EnrollmentKey, ExerciseSupport.Learner> table) {
    table.put(ExerciseSupport.enrollmentKey("EDA", "A1"), ExerciseSupport.learner("Ana", 101));
    table.put(ExerciseSupport.enrollmentKey("MAT", "B2"), ExerciseSupport.learner("Luis", 203));
    table.put(ExerciseSupport.enrollmentKey("FIS", "C3"), ExerciseSupport.learner("Mia", 305));
    ExerciseSupport.Learner previous = table.put(
        ExerciseSupport.enrollmentKey("MAT", "B2"),
        ExerciseSupport.learner("Eva", 99));
    ExerciseSupport.Learner removed = table.remove(ExerciseSupport.enrollmentKey("FIS", "C3"));
    return ExerciseSupport.format(
        ExerciseSupport.named("previous", previous),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(table)),
        ExerciseSupport.named("getMAT", table.get(ExerciseSupport.enrollmentKey("MAT", "B2"))),
        ExerciseSupport.named("removedFIS", removed),
        ExerciseSupport.named("containsEDA", table.containsKey(ExerciseSupport.enrollmentKey("EDA", "A1"))));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(LinkedHashMap<ExerciseSupport.EnrollmentKey, ExerciseSupport.Learner> table) {
    table.put(ExerciseSupport.enrollmentKey("EDA", "A1"), ExerciseSupport.learner("Ana", 101));
    table.put(ExerciseSupport.enrollmentKey("MAT", "B2"), ExerciseSupport.learner("Luis", 203));
    table.put(ExerciseSupport.enrollmentKey("FIS", "C3"), ExerciseSupport.learner("Mia", 305));
    ExerciseSupport.Learner previous = table.put(
        ExerciseSupport.enrollmentKey("MAT", "B2"),
        ExerciseSupport.learner("Eva", 99));
    ExerciseSupport.Learner removed = table.remove(ExerciseSupport.enrollmentKey("FIS", "C3"));
    return ExerciseSupport.format(
        ExerciseSupport.named("previous", previous),
        ExerciseSupport.named("size", table.size()),
        ExerciseSupport.named("getMAT", table.get(ExerciseSupport.enrollmentKey("MAT", "B2"))),
        ExerciseSupport.named("removedFIS", removed),
        ExerciseSupport.named("containsEDA", table.containsKey(ExerciseSupport.enrollmentKey("EDA", "A1"))));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(LinkedHashMap<ExerciseSupport.EnrollmentKey, ExerciseSupport.Learner> table) {
    table.put(ExerciseSupport.enrollmentKey("EDA", "A1"), ExerciseSupport.learner("Ana", 101));
    table.put(ExerciseSupport.enrollmentKey("MAT", "B2"), ExerciseSupport.learner("Luis", 203));
    table.put(ExerciseSupport.enrollmentKey("FIS", "C3"), ExerciseSupport.learner("Mia", 305));
    ExerciseSupport.Learner previous = table.put(
        ExerciseSupport.enrollmentKey("MAT", "B2"),
        ExerciseSupport.learner("Eva", 99));
    ExerciseSupport.Learner removed = table.remove(ExerciseSupport.enrollmentKey("FIS", "C3"));
    return ExerciseSupport.format(
        ExerciseSupport.named("previous", previous),
        ExerciseSupport.named("size", table.entrySet().stream().count()),
        ExerciseSupport.named("getMAT", table.get(ExerciseSupport.enrollmentKey("MAT", "B2"))),
        ExerciseSupport.named("removedFIS", removed),
        ExerciseSupport.named("containsEDA", table.containsKey(ExerciseSupport.enrollmentKey("EDA", "A1"))));
  }

}
