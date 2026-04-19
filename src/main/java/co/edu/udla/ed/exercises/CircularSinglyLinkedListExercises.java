package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

import co.edu.udla.ed.impl.collections.CollectionsCircularSinglyLinkedList;
import co.edu.udla.ed.impl.linear.LinearCircularSinglyLinkedList;
import co.edu.udla.ed.impl.scratch.CircularSinglyLinkedList;

abstract class AbstractCircularSinglyLinkedListExercise extends AbstractListExercise {

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

