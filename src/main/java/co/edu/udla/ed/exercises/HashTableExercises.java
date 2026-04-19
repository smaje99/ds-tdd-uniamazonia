package co.edu.udla.ed.exercises;


import co.edu.udla.ed.api.HashTable;
import co.edu.udla.ed.impl.collections.CollectionsHashTable;
import co.edu.udla.ed.impl.linear.LinearHashTable;
import co.edu.udla.ed.impl.scratch.SeparateChainingHashTable;

/**
 * Base wiring for the string-key hash-table exercise series.
 */
abstract class AbstractStringHashTableExercise extends AbstractHashTableExercise<String, Integer> {

  @Override
  protected HashTable<String, Integer> createScratch() {
    return new SeparateChainingHashTable<>();
  }

  @Override
  protected HashTable<String, Integer> createLinear() {
    return new LinearHashTable<>();
  }

  @Override
  protected HashTable<String, Integer> createCollections() {
    return new CollectionsHashTable<>();
  }

}

/**
 * Base wiring for the collision-focused hash-table exercise that uses forced-collision keys.
 */
abstract class AbstractCollisionHashTableExercise
    extends AbstractHashTableExercise<ExerciseSupport.BadHashKey, Integer> {

  @Override
  protected HashTable<ExerciseSupport.BadHashKey, Integer> createScratch() {
    return new SeparateChainingHashTable<>();
  }

  @Override
  protected HashTable<ExerciseSupport.BadHashKey, Integer> createLinear() {
    return new LinearHashTable<>();
  }

  @Override
  protected HashTable<ExerciseSupport.BadHashKey, Integer> createCollections() {
    return new CollectionsHashTable<>();
  }

  protected final ExerciseSupport.BadHashKey key(String id) {
    return new ExerciseSupport.BadHashKey(id);
  }

}

/**
 * Base wiring for the domain-object hash-table exercise that uses readable enrollment keys and
 * learner values.
 */
abstract class AbstractDomainHashTableExercise
    extends AbstractHashTableExercise<ExerciseSupport.EnrollmentKey, ExerciseSupport.Learner> {

  @Override
  protected HashTable<ExerciseSupport.EnrollmentKey, ExerciseSupport.Learner> createScratch() {
    return new SeparateChainingHashTable<>();
  }

  @Override
  protected HashTable<ExerciseSupport.EnrollmentKey, ExerciseSupport.Learner> createLinear() {
    return new LinearHashTable<>();
  }

  @Override
  protected HashTable<ExerciseSupport.EnrollmentKey, ExerciseSupport.Learner> createCollections() {
    return new CollectionsHashTable<>();
  }

  protected final ExerciseSupport.EnrollmentKey key(String course, String section) {
    return ExerciseSupport.enrollmentKey(course, section);
  }

}
