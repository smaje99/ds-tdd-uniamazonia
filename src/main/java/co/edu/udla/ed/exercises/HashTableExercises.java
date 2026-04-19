package co.edu.udla.ed.exercises;


import co.edu.udla.ed.api.HashTable;
import co.edu.udla.ed.impl.collections.CollectionsHashTable;
import co.edu.udla.ed.impl.linear.LinearHashTable;
import co.edu.udla.ed.impl.scratch.SeparateChainingHashTable;

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
