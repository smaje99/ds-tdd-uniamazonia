package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

import co.edu.udla.ed.impl.collections.CollectionsCircularSinglyLinkedList;
import co.edu.udla.ed.impl.linear.LinearCircularSinglyLinkedList;
import co.edu.udla.ed.impl.scratch.CircularSinglyLinkedList;

abstract class AbstractCircularSinglyLinkedListExercise extends AbstractListExercise<String> {

  @Override
  protected List<String> createScratch() {
    return new CircularSinglyLinkedList<>();
  }

  @Override
  protected List<String> createLinear() {
    return new LinearCircularSinglyLinkedList<>();
  }

  @Override
  protected List<String> createCollections() {
    return new CollectionsCircularSinglyLinkedList<>();
  }

}

abstract class AbstractCircularSinglyLinkedListDomainExercise extends AbstractListExercise<ExerciseSupport.Learner> {

  @Override
  protected List<ExerciseSupport.Learner> createScratch() {
    return new CircularSinglyLinkedList<>();
  }

  @Override
  protected List<ExerciseSupport.Learner> createLinear() {
    return new LinearCircularSinglyLinkedList<>();
  }

  @Override
  protected List<ExerciseSupport.Learner> createCollections() {
    return new CollectionsCircularSinglyLinkedList<>();
  }

}
