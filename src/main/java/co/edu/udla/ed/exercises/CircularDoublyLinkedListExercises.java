package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

import co.edu.udla.ed.impl.collections.CollectionsCircularDoublyLinkedList;
import co.edu.udla.ed.impl.linear.LinearCircularDoublyLinkedList;
import co.edu.udla.ed.impl.scratch.CircularDoublyLinkedList;

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
