package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.SeparateChainingHashTable;

public final class HashTableExercise05 {

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
