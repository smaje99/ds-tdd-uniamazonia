package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.Stack;

import java.util.ArrayList;

import co.edu.udla.ed.impl.collections.CollectionsStack;
import co.edu.udla.ed.impl.linear.LinearStack;
import co.edu.udla.ed.impl.scratch.LinkedStack;

abstract class AbstractStackLinkedExercise extends AbstractStackExercise {

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

  protected final String popAll(Stack<String> stack) {
    java.util.List<String> values = new ArrayList<>();
    while (!stack.isEmpty()) {
      values.add(stack.pop());
    }
    return values.toString();
  }

}

