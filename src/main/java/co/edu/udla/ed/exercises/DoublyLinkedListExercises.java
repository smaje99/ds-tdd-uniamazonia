package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

import co.edu.udla.ed.impl.collections.CollectionsDoublyLinkedList;
import co.edu.udla.ed.impl.linear.LinearDoublyLinkedList;
import co.edu.udla.ed.impl.scratch.DoublyLinkedList;

abstract class AbstractDoublyLinkedListExercise extends AbstractListExercise {

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

