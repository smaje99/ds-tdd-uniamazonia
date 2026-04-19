package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Queue;

import co.edu.udla.ed.impl.collections.CollectionsQueue;
import co.edu.udla.ed.impl.linear.LinearQueue;
import co.edu.udla.ed.impl.scratch.LinkedQueue;

/**
 * Base wiring for the linked queue exercise series that uses scalar values.
 */
abstract class AbstractQueueLinkedExercise extends AbstractQueueExercise<String> {

  @Override
  protected Queue<String> createScratch() {
    return new LinkedQueue<>();
  }

  @Override
  protected Queue<String> createLinear() {
    return new LinearQueue<>();
  }

  @Override
  protected Queue<String> createCollections() {
    return new CollectionsQueue<>();
  }

}

/**
 * Base wiring for the linked queue exercise series that uses learner domain objects.
 */
abstract class AbstractQueueLinkedDomainExercise extends AbstractQueueExercise<ExerciseSupport.Learner> {

  @Override
  protected Queue<ExerciseSupport.Learner> createScratch() {
    return new LinkedQueue<>();
  }

  @Override
  protected Queue<ExerciseSupport.Learner> createLinear() {
    return new LinearQueue<>();
  }

  @Override
  protected Queue<ExerciseSupport.Learner> createCollections() {
    return new CollectionsQueue<>();
  }

}
