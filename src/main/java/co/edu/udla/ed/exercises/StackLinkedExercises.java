package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Stack;

import co.edu.udla.ed.impl.collections.CollectionsStack;
import co.edu.udla.ed.impl.linear.LinearStack;
import co.edu.udla.ed.impl.scratch.LinkedStack;

/**
 * Base wiring for the linked stack exercise series that uses scalar values.
 */
abstract class AbstractStackLinkedExercise extends AbstractStackExercise<String> {

  @Override
  protected Stack<String> createScratch() {
    return new LinkedStack<>();
  }

  @Override
  protected Stack<String> createLinear() {
    return new LinearStack<>();
  }

  @Override
  protected Stack<String> createCollections() {
    return new CollectionsStack<>();
  }

}

/**
 * Base wiring for the linked stack exercise series that uses learner domain objects.
 */
abstract class AbstractStackLinkedDomainExercise extends AbstractStackExercise<ExerciseSupport.Learner> {

  @Override
  protected Stack<ExerciseSupport.Learner> createScratch() {
    return new LinkedStack<>();
  }

  @Override
  protected Stack<ExerciseSupport.Learner> createLinear() {
    return new LinearStack<>();
  }

  @Override
  protected Stack<ExerciseSupport.Learner> createCollections() {
    return new CollectionsStack<>();
  }

}
