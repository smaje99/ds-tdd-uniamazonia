package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

import co.edu.udla.ed.impl.collections.CollectionsSimpleList;
import co.edu.udla.ed.impl.linear.LinearSimpleList;
import co.edu.udla.ed.impl.scratch.StaticSimpleList;

/**
 * Base wiring for the array-backed simple-list exercise series that uses scalar values.
 */
abstract class AbstractSimpleListStaticExercise extends AbstractListExercise<String> {

  @Override
  protected List<String> createScratch() {
    return new StaticSimpleList<>();
  }

  @Override
  protected List<String> createLinear() {
    return new LinearSimpleList<>();
  }

  @Override
  protected List<String> createCollections() {
    return new CollectionsSimpleList<>();
  }

}

/**
 * Base wiring for the array-backed simple-list exercise series that uses learner domain objects.
 */
abstract class AbstractSimpleListStaticDomainExercise extends AbstractListExercise<ExerciseSupport.Learner> {

  @Override
  protected List<ExerciseSupport.Learner> createScratch() {
    return new StaticSimpleList<>();
  }

  @Override
  protected List<ExerciseSupport.Learner> createLinear() {
    return new LinearSimpleList<>();
  }

  @Override
  protected List<ExerciseSupport.Learner> createCollections() {
    return new CollectionsSimpleList<>();
  }

}
