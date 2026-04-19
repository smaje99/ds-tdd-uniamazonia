package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

import co.edu.udla.ed.impl.collections.CollectionsCircularDoublyLinkedList;
import co.edu.udla.ed.impl.linear.LinearCircularDoublyLinkedList;
import co.edu.udla.ed.impl.scratch.CircularDoublyLinkedList;

/**
 * Base wiring for the circular doubly linked list exercise series that uses scalar values.
 */
abstract class AbstractCircularDoublyLinkedListExercise extends AbstractListExercise<String> {

  @Override
  protected List<String> createScratch() {
    return new CircularDoublyLinkedList<>();
  }

  @Override
  protected List<String> createLinear() {
    return new LinearCircularDoublyLinkedList<>();
  }

  @Override
  protected List<String> createCollections() {
    return new CollectionsCircularDoublyLinkedList<>();
  }

}

/**
 * Base wiring for the circular doubly linked list exercise series that uses learner domain objects.
 */
abstract class AbstractCircularDoublyLinkedListDomainExercise extends AbstractListExercise<ExerciseSupport.Learner> {

  @Override
  protected List<ExerciseSupport.Learner> createScratch() {
    return new CircularDoublyLinkedList<>();
  }

  @Override
  protected List<ExerciseSupport.Learner> createLinear() {
    return new LinearCircularDoublyLinkedList<>();
  }

  @Override
  protected List<ExerciseSupport.Learner> createCollections() {
    return new CollectionsCircularDoublyLinkedList<>();
  }

}
