package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.api.Queue;
import co.edu.udla.ed.impl.collections.CollectionsQueue;
import co.edu.udla.ed.impl.linear.LinearQueue;
import co.edu.udla.ed.impl.scratch.StaticQueue;

abstract class AbstractQueueStaticExercise extends AbstractQueueExercise {

  @Override
  protected Queue<String> createScratch() {
    return new StaticQueue<>();
  }

  @Override
  protected Queue<String> createLinear() {
    return new LinearQueue<>();
  }

  @Override
  protected Queue<String> createCollections() {
    return new CollectionsQueue<>();
  }

  protected final String dequeueAll(Queue<String> queue) {
    java.util.List<String> values = new ArrayList<>();
    while (!queue.isEmpty()) {
      values.add(queue.dequeue());
    }
    return values.toString();
  }

}

