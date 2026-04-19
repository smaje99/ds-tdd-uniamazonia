package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;
import co.edu.udla.ed.impl.collections.CollectionsSimpleList;
import co.edu.udla.ed.impl.linear.LinearSimpleList;
import co.edu.udla.ed.impl.scratch.SinglyLinkedList;

abstract class AbstractSimpleListLinkedExercise extends AbstractListExercise {

  @Override
  protected List<String> createScratch() {
    return new SinglyLinkedList<>();
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

