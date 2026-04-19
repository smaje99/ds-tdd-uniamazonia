package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Queue;
import co.edu.udla.ed.impl.collections.CollectionsQueue;
import co.edu.udla.ed.impl.linear.LinearQueue;
import co.edu.udla.ed.impl.scratch.StaticQueue;

abstract class AbstractQueueStaticExercise extends AbstractQueueExercise<String> {

  @Override
  protected Queue<String> createScratch() {
    return new StaticQueue<>();
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

abstract class AbstractQueueStaticDomainExercise extends AbstractQueueExercise<ExerciseSupport.Learner> {

  @Override
  protected Queue<ExerciseSupport.Learner> createScratch() {
    return new StaticQueue<>();
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
