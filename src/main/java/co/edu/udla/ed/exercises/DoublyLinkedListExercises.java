package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

import co.edu.udla.ed.impl.collections.CollectionsDoublyLinkedList;
import co.edu.udla.ed.impl.linear.LinearDoublyLinkedList;
import co.edu.udla.ed.impl.scratch.DoublyLinkedList;

/**
 * Base wiring for the doubly linked list exercise series that uses scalar values.
 */
abstract class AbstractDoublyLinkedListExercise extends AbstractListExercise<String> {

  @Override
  protected List<String> createScratch() {
    return new DoublyLinkedList<>();
  }

  @Override
  protected List<String> createLinear() {
    return new LinearDoublyLinkedList<>();
  }

  @Override
  protected List<String> createCollections() {
    return new CollectionsDoublyLinkedList<>();
  }

}

/**
 * Base wiring for the doubly linked list exercise series that uses learner domain objects.
 */
abstract class AbstractDoublyLinkedListDomainExercise extends AbstractListExercise<ExerciseSupport.Learner> {

  @Override
  protected List<ExerciseSupport.Learner> createScratch() {
    return new DoublyLinkedList<>();
  }

  @Override
  protected List<ExerciseSupport.Learner> createLinear() {
    return new LinearDoublyLinkedList<>();
  }

  @Override
  protected List<ExerciseSupport.Learner> createCollections() {
    return new CollectionsDoublyLinkedList<>();
  }

}
